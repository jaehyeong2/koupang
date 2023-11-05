package jjfactory.koupang.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
class UserCoupon(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val userId: Long,
    val couponId: Long,

    var isUsed: Boolean = false,
    var usedDt: LocalDateTime? = null,

    val createDt: LocalDateTime,
    val expireDt: LocalDateTime
) {

    fun use(){
        isUsed = true
        usedDt = LocalDateTime.now()
    }

    companion object {
        fun of(userId:Long, couponId: Long): UserCoupon {
            return UserCoupon(
                userId = userId,
                couponId = couponId,
                createDt = LocalDateTime.now(),
                expireDt = LocalDateTime.now().plusYears(1).minusDays(1),
            )
        }
    }

}