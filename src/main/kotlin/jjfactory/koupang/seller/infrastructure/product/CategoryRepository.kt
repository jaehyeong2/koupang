package jjfactory.koupang.seller.infrastructure.product

import jjfactory.koupang.seller.domain.product.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}