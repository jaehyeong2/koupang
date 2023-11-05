package jjfactory.koupang.batch

import ch.qos.logback.classic.Logger
import jjfactory.koupang.user.domain.UserCoupon
import jjfactory.koupang.user.infrastructure.UserCouponRepository
import org.apache.catalina.core.ApplicationContext
import org.slf4j.LoggerFactory
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestApi(
    private val userCouponRepository: UserCouponRepository,
    private val userDisablingJobConfig: UserDisablingJobConfig,
    private val jobRepository: JobRepository,
    private val jobLauncher: JobLauncher
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/batch/test")
    fun test(){
        jobLauncher.run(userDisablingJobConfig.userDisableJob(jobRepository), JobParameters())

//        for (i: Int in 1.. 40){
//            userCouponRepository.save(UserCoupon.of(1L, 20L))
//        }

//        JobEx
    }
}