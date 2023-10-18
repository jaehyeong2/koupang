package jjfactory.koupang.user.infrastructure

import jjfactory.koupang.user.domain.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long>{
}