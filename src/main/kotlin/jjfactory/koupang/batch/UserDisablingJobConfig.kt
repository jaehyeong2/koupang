package jjfactory.koupang.batch

import jakarta.persistence.EntityManagerFactory
import jjfactory.koupang.user.domain.UserCoupon
import jjfactory.koupang.user.infrastructure.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.database.JpaCursorItemReader
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.math.exp

@Configuration
class UserDisablingJobConfig(
    private val userRepository: UserRepository,
    private val emf: EntityManagerFactory
) {
    private val logger = LoggerFactory.getLogger(javaClass)

//    @Bean
//    @JobScope
//    fun createJobParameter(@Value("#{jobParameters[expireDt]}") expireDtStr: String?): CouponExpireJobParameter{
//        return CouponExpireJobParameter(expireDtStr)
//    }

    @Bean
    fun userCouponExpireJob(jobRepository: JobRepository): Job {
        logger.info("job start")

        return JobBuilder("userCouponExpireJob", jobRepository)
            .start(userCouponExpireStep(jobRepository, null))
            .build()
    }

    @JobScope
    @Bean
    fun userCouponExpireStep(jobRepository: JobRepository, @Value("#{jobParameters[expireDt]}") expireDt: LocalDateTime?): Step {
        return StepBuilder("userCouponExpireStep", jobRepository)
            .chunk<UserCoupon, UserCoupon>(10, JpaTransactionManager(emf))
            .reader(couponReader(null))
            .processor(processor())
            .writer(writer())
            .build()
    }

    @Bean
    @StepScope
    fun couponReader(@Value("#{jobParameters[expireDt]}") expireDt: LocalDateTime?): JpaCursorItemReader<UserCoupon>{
        val map : MutableMap<String, Any?> = HashMap()
        map.put("expireDt", expireDt)

        return JpaCursorItemReaderBuilder<UserCoupon>()
            .name("couponReader")
            .maxItemCount(100)
            .entityManagerFactory(emf)
            .queryString("select uc from UserCoupon uc where uc.expireDt >= :expireDt")
            .parameterValues(map)
            .build()
    }


    @Bean
    fun writer(): JpaItemWriter<UserCoupon> {
        return JpaItemWriterBuilder<UserCoupon>()
            .entityManagerFactory(emf)
            .build()
    }

    @Bean
    fun processor(): ItemProcessor<UserCoupon, UserCoupon> {
        return ItemProcessor {
            it.expire()
            it
        }
    }
}