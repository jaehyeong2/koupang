package jjfactory.koupang.batch

import jakarta.persistence.EntityManagerFactory
import jjfactory.koupang.user.domain.User
import jjfactory.koupang.user.domain.UserCoupon
import jjfactory.koupang.user.infrastructure.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.JpaCursorItemReader
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder
import org.springframework.batch.item.database.orm.JpaQueryProvider
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.time.LocalDateTime

@Configuration
class UserDisablingJobConfig(
    private val userRepository: UserRepository,
    private val entityManagerFactory: EntityManagerFactory
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun userDisableJob(jobRepository: JobRepository): Job {
        logger.info("job start")
        return JobBuilder("userDisableJob", jobRepository)
            .start(userDisableStep(jobRepository, LocalDateTime.now().toString()))
            .build()
    }

    @JobScope
    @Bean
    fun userDisableStep(jobRepository: JobRepository, @Value("#{jobParameters[expireDt]}") expireDt: String?): Step {
        logger.info("expiredt : {}", expireDt)
        logger.info("step start")
        return StepBuilder("userDisableStep", jobRepository)
            .chunk<UserCoupon, UserCoupon>(10, JpaTransactionManager())
            .reader(expireCouponReader(expireDt))
            .processor(processor())
            .writer(writer())
            .build()
    }

    @Bean
    @StepScope
    fun expireCouponReader(@Value("#{jobParameters[expireDt]}") expireDt: String?): JpaCursorItemReader<UserCoupon>{
        logger.info("reader start")
        val map : MutableMap<String, Any?> = HashMap()
        map.put("expireDt", expireDt)

        return JpaCursorItemReaderBuilder<UserCoupon>()
            .name("expireCouponReader")
            .maxItemCount(10)
            .entityManagerFactory(entityManagerFactory)
            .queryString("select * from user_coupon uc where uc.expireDt <= ?")
            .parameterValues(map)
            .build()
    }


    @Bean
    fun writer(): JpaItemWriter<UserCoupon> {
        logger.info("writer start")
        return JpaItemWriterBuilder<UserCoupon>()
            .entityManagerFactory(entityManagerFactory)
            .build()
    }

    @Bean
    fun processor(): ItemProcessor<UserCoupon, UserCoupon> {
        logger.info("processor start")
        return ItemProcessor {
            it.use()
            it
        }
    }
}