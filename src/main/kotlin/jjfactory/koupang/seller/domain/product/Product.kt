package jjfactory.koupang.seller.domain.product

import jakarta.persistence.*
import jjfactory.koupang.seller.domain.Seller

@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val seller: Seller,

    val name: String,
    val code: String,
    val qty: Int = 0
)