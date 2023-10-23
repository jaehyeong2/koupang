package jjfactory.koupang.user.domain

class UserInfo {
    data class Main(
        val name: String,
        val username: String,
        val address: Address
    )
}