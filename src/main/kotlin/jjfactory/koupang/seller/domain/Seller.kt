package jjfactory.koupang.seller.domain

import jakarta.persistence.*

@Table(indexes = [Index(name = "code", columnList = "code")])
@Entity
class Seller(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val bizNum: String,
    val code: String
)