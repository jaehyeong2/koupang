package jjfactory.koupang.user.application

import jjfactory.koupang.user.domain.UserService
import org.springframework.stereotype.Service

@Service
class UserFacade(
    private val userService: UserService
) {
}