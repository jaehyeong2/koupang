package jjfactory.koupang.user.infrastructure

import jjfactory.koupang.user.domain.UserCoupon
import org.springframework.data.jpa.repository.JpaRepository

interface UserCouponRepository : JpaRepository<UserCoupon, Long> {
}