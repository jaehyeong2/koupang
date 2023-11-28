package jjfactory.koupang.system

import jakarta.persistence.*
import jjfactory.koupang.user.domain.User

@Entity
class ActivityLog(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val member: Member,

    val viewCnt :Int,
    val commentCnt :Int,
    val postCnt :Int,
) {
}