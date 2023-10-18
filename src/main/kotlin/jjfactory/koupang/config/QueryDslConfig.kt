package jjfactory.koupang.config

import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.querydsl.jpa.impl.JPAQueryFactory

@Configuration
class QueryDslConfig(
    private val entityManager: EntityManager
) {
    @Bean
    fun queryFactory(): JPAQueryFactory{
        return JPAQueryFactory(entityManager)
    }
}