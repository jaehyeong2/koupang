package jjfactory.koupang.seller.infrastructure.product

import com.querydsl.jpa.impl.JPAQueryFactory
import jjfactory.koupang.seller.domain.product.ProductReview
import jjfactory.koupang.seller.domain.product.QProductReview.productReview
import org.springframework.stereotype.Repository

@Repository
class ProductReviewDslRepo(
    private val queryFactory: JPAQueryFactory
) {
    fun getReviewsByUserId(userId: Long): MutableList<ProductReview>? {
        return queryFactory.select(productReview)
            .from(productReview)
            .where(productReview.userId.eq(userId))
            .fetch();
    }
}