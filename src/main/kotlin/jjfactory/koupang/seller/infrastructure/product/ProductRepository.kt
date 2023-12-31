package jjfactory.koupang.seller.infrastructure.product

import jjfactory.koupang.seller.domain.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCode(code: String): Product?
    fun findAllBySellerId(sellerId: Long): List<Product>
}