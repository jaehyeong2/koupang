package jjfactory.koupang.user.infrastructure

import jjfactory.koupang.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
}