package jjfactory.koupang.seller.domain.product.qna

import jakarta.persistence.*
import jjfactory.koupang.seller.domain.product.Product

@Entity
class Question(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val userId: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,

    val content: String,
) {
}