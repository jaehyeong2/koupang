package jjfactory.koupang.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column
    val zipCode: String,
    @Column
    val city: String,
    @Column
    val street: String
)