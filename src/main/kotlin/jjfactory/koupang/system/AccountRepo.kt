package jjfactory.koupang.system

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepo : JpaRepository<Account, Long>{
    fun findByUsername(username: String): Account
}