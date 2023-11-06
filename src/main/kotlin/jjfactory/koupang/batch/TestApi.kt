package jjfactory.koupang.batch

import jjfactory.koupang.user.domain.UserCoupon
import jjfactory.koupang.user.infrastructure.UserCouponRepository
import org.slf4j.LoggerFactory
import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class TestApi(
    private val userCouponRepository: UserCouponRepository,
    private val userDisablingJobConfig: UserDisablingJobConfig,
    private val jobRepository: JobRepository,
    private val jobLauncher: JobLauncher,
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/batch/test")
    fun test(){
        val jobParameters = JobParametersBuilder().addLocalDateTime("expireDt", LocalDateTime.now().minusMonths(10))
            .toJobParameters()

        jobLauncher.run(userDisablingJobConfig.userCouponExpireJob(jobRepository), jobParameters)

//        for (i: Int in 1.. 40){
//            userCouponRepository.save(UserCoupon.of(1L, 20L))
//        }

    }
}