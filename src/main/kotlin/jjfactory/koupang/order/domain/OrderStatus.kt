package jjfactory.koupang.order.domain

enum class OrderStatus {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED
}