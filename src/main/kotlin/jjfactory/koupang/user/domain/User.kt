package jjfactory.koupang.user.domain

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils

@Table(name = "users")
@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    val name: String,
    var username: String,

    val test: String? = null,

    @Embedded
    var address: Address,
){

    fun modify(username: String, address: Address){
        if (StringUtils.hasText(username)) this.username = username
        if (!ObjectUtils.isEmpty(address)) this.address = address
    }


    companion object{
        fun of(name: String, username: String, address: Address): User{
            return User(
                name = name,
                username = username,
                address = address
            )
        }
    }
}