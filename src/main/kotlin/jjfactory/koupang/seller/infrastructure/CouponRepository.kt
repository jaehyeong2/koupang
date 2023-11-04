package jjfactory.koupang.seller.infrastructure

import jjfactory.koupang.seller.domain.Seller
import jjfactory.koupang.seller.domain.coupon.Coupon
import org.springframework.data.jpa.repository.JpaRepository

interface CouponRepository : JpaRepository<Coupon, Long> {
}