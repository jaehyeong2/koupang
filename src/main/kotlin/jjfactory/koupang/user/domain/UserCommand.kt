package jjfactory.koupang.user.domain

class UserCommand {
    data class Create(
        val name: String,
        val username: String,
        val address: Address
    ){
        fun toEntity(): User{
            return User.of(name, username, address)
        }
    }

    data class Modify(
        val username: String,
        val address: Address
    )
}