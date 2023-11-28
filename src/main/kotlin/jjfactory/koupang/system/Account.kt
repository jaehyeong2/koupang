package jjfactory.koupang.system

import jakarta.persistence.*

@Entity
class Account(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val member: Member,

    @Column(unique = true)
    var username: String
) {
}