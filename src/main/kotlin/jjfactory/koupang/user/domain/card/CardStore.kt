package jjfactory.koupang.user.domain.card

interface CardStore {
    fun store(card: Card): Card
}