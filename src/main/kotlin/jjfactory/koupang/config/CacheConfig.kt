package jjfactory.koupang.config

import com.github.benmanes.caffeine.cache.Caffeine.newBuilder
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.util.concurrent.TimeUnit

@EnableCaching
@Configuration
class CacheConfig {

    @Bean
    @Primary
    fun shortCacheManager(): CaffeineCacheManager {
        val manager = CaffeineCacheManager()

        val caffeine = newBuilder()
            .maximumSize(200)
            .expireAfterAccess(3, TimeUnit.SECONDS)

        manager.setCaffeine(caffeine)
        return manager
    }

    @Bean
    fun longCacheManager(): CaffeineCacheManager {
        val manager = CaffeineCacheManager()

        val caffeine = newBuilder()
            .maximumSize(200)
            .expireAfterAccess(10, TimeUnit.SECONDS)

        manager.setCaffeine(caffeine)
        return manager
    }
}