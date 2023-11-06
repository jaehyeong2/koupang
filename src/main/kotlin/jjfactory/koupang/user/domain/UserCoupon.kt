package jjfactory.koupang.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
class UserCoupon(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val userId: Long,
    val couponId: Long,

    private var isUsed: Boolean = false,
    private var usedDt: LocalDateTime? = null,
    @ColumnDefault("false")
    private var isExpired: Boolean = false,

    val createDt: LocalDateTime,
    val expireDt: LocalDateTime
) {

    fun expire(){
        if(!isExpired){
            isExpired = true
        }
    }

    fun use(){
        if(!isUsed){
            isUsed = true
            usedDt = LocalDateTime.now()
        }
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