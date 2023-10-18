package jjfactory.koupang.payments.domain

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Payments(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?,

    val orderId: Long,
    val cardId: Long

)