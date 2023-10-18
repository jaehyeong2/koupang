package jjfactory.koupang.user.domain.card

import jakarta.persistence.*
import jjfactory.koupang.user.domain.Users

@Entity
class Card(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long?,
    @ManyToOne(fetch = FetchType.LAZY)
    val users: Users,

    val cardNumber: String,
    val name: String,
)