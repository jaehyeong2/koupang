package jjfactory.koupang.seller.domain.product

import jakarta.persistence.*

@Entity
class ProductReview(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
    val userId: Long,

    var star: Int? = null,
    var content: String
)