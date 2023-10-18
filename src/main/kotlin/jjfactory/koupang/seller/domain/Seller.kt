package jjfactory.koupang.seller.domain

import jakarta.persistence.*

@Table(indexes = [Index(columnList = "key")])
@Entity
class Seller(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val bizNum: String,
    val key: String
)