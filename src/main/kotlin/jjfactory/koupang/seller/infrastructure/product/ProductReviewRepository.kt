package jjfactory.koupang.seller.infrastructure.product

import jjfactory.koupang.seller.domain.product.ProductReview
import org.springframework.data.jpa.repository.JpaRepository

interface ProductReviewRepository : JpaRepository<ProductReview, Long> {
}