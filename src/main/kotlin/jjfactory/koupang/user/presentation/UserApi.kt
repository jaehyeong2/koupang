package jjfactory.koupang.user.presentation

import jjfactory.koupang.user.application.UserFacade
import jjfactory.koupang.user.domain.UserCommand
import jjfactory.koupang.user.domain.UserInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserApi(
    private val userFacade: UserFacade
) {

    @GetMapping("/{id}")
    fun getInfo(@PathVariable id: Long): UserInfo.Main {
        return userFacade.getInfo(id)
    }

    @GetMapping
    fun getAll(): List<UserInfo.Main> {
        return userFacade.getAllUsers()
    }

    @PostMapping
    fun store(command: UserCommand.Create){
        userFacade.store(command)
    }
}