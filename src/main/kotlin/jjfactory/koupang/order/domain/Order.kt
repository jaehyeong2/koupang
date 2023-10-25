package jjfactory.koupang.order.domain

import jakarta.persistence.*
import jjfactory.koupang.common.model.Money

@Table(name = "orders")
@Entity
class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    val userId: Long,

    val key: String,

    val totalAmounts: Int,

    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.PAYMENT_WAITING
){

    fun startShipping(){
        verifyStatus()
        this.status = OrderStatus.SHIPPED
    }

    fun cancel(){
        verifyNotYetShipped()
        status = OrderStatus.CANCELED
    }

    private fun verifyStatus(){
        verifyNotYetShipped()
        verifyNotCanceled()
    }

    private fun verifyNotCanceled(){
        if (status == OrderStatus.CANCELED) throw IllegalArgumentException()
    }

    private fun verifyNotYetShipped(){
        if (!isNotYetShipped()) throw IllegalArgumentException()
    }

    private fun isNotYetShipped(): Boolean{
        return status == OrderStatus.PREPARING || status == OrderStatus.PAYMENT_WAITING
    }

}