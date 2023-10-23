package jjfactory.koupang.user.infrastructure

import jjfactory.koupang.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
    fun findByUsername(username: String): User?
    fun existsByUsername(username: String): Boolean
}