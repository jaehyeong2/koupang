package jjfactory.koupang.delivery.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Delivery(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?,

    val orderId: Long,

    var status: String
) {
}