package jjfactory.koupang.seller.domain.product

import jakarta.persistence.*

@Entity
class ProductReview(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
    val userId: Long,

    var star: Int,
    val content: String
)