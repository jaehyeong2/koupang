package jjfactory.koupang.config

import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableCaching
@Configuration
class CacheConfig {

    @Bean
    fun cacheManager(): CaffeineCacheManager {
        return CaffeineCacheManager(

        )
    }
}