package jjfactory.koupang.seller.infrastructure

import jjfactory.koupang.seller.domain.Seller
import org.springframework.data.jpa.repository.JpaRepository

interface SellerRepository : JpaRepository<Seller, Long> {
}