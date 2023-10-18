package jjfactory.koupang.payments.domain

import jakarta.persistence.*

@Entity
class Billing(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @OneToOne(fetch = FetchType.LAZY)
    val payments: Payments

)