package jjfactory.koupang.order.domain

interface OrderStore {
    fun store(order: Order): Order
}