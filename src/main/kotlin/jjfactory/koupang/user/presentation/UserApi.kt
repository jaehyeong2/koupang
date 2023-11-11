package jjfactory.koupang.user.presentation

import jjfactory.koupang.user.application.UserFacade
import jjfactory.koupang.user.domain.UserCommand
import jjfactory.koupang.user.domain.UserInfo
import jjfactory.koupang.user.domain.UserReader
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserApi(
    private val userFacade: UserFacade,
    private val userReader: UserReader
) {

    @GetMapping("/{id}")
    fun getInfo(@PathVariable id: Long): UserInfo.Main {
        return userFacade.getInfo(id)
    }

    @GetMapping("/{id}/2")
    fun getInfo2(@PathVariable id: Long): UserInfo.Main {
        return userFacade.getInfo2(id)
    }

    @GetMapping
    fun getAll(): List<UserInfo.Main> {
        return userFacade.getAllUsers()
    }

    @PostMapping
    fun store(command: UserCommand.Create){
        userFacade.store(command)
    }

    @Transactional
    @PutMapping
    fun put(username: String){
        userReader.getById(1L).username = username
    }
}