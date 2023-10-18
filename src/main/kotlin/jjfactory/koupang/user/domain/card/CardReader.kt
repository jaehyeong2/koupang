package jjfactory.koupang.user.domain.card

interface CardReader {
    fun getById(id: Long): Card
    fun getByUserId(userId: Long): List<Card>
}