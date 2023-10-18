package jjfactory.koupang.order.domain

interface OrderReader {
    fun getById(id: Long): Order
    fun getByKey(key: String): Order
}