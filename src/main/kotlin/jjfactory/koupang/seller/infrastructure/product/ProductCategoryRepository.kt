package jjfactory.koupang.seller.infrastructure.product

import jjfactory.koupang.seller.domain.product.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductCategoryRepository : JpaRepository<Product, Long> {
}