package jjfactory.koupang.user.domain

interface UserService {
    fun store(command: UserCommand.Create): Long
    fun getInfo(id: Long): UserInfo.Main
    fun modify(id: Long, command: UserCommand.Modify): Long
    fun getAllUsers(): List<UserInfo.Main>
}