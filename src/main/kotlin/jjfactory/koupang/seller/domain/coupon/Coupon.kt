package jjfactory.koupang.seller.domain.coupon

import jakarta.persistence.*
import jjfactory.koupang.seller.domain.Seller

@Entity
class Coupon(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val seller: Seller,

    val name: String,
    val description: String
) {

}