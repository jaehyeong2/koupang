package jjfactory.koupang.payments.domain

import jakarta.persistence.*

@Entity
class Payments(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?,

    val orderId: Long,
    val cardId: Long,

    val paymentKey: String
)
