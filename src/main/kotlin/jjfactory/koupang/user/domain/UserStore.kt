package jjfactory.koupang.user.domain

interface UserStore {
    fun store(user: User): User
}