package jjfactory.koupang.common.model

class Money(
    private val value: Int
) {
    fun multiply(multiplier: Int): Money {
        return Money(value * multiplier)
    }
}