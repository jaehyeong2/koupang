package jjfactory.koupang.seller.domain.product

import jakarta.persistence.*
import jjfactory.koupang.seller.domain.Seller

@Table(indexes = [Index(name = "code", columnList = "code")])
@Entity
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @ManyToOne(fetch = FetchType.LAZY)
    val seller: Seller,

    val name: String,
    val code: String
)