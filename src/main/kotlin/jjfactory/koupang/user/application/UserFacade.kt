package jjfactory.koupang.user.application

import jjfactory.koupang.user.domain.UserCommand
import jjfactory.koupang.user.domain.UserInfo
import jjfactory.koupang.user.domain.UserService
import org.springframework.stereotype.Service

@Service
class UserFacade(
    private val userService: UserService
) {
    fun getInfo(id: Long): UserInfo.Main {
        return userService.getInfo(id)
    }

    fun getInfo2(id: Long): UserInfo.Main {
        return userService.getInfo2(id)
    }

    fun store(command: UserCommand.Create){
        userService.store(command)
    }

    fun getAllUsers(): List<UserInfo.Main> {
        return userService.getAllUsers()
    }
}