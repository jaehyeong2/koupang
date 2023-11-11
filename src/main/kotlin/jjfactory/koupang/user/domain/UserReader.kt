package jjfactory.koupang.user.domain

interface UserReader {
    fun getById(id: Long): User
    fun getByUsername(username: String): User
    fun existByUsername(username: String): Boolean
    fun getAllUsers(): List<User>
}