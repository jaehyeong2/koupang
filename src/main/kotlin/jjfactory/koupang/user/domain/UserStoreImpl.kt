package jjfactory.koupang.user.domain

import jjfactory.koupang.user.infrastructure.UserRepository
import org.springframework.stereotype.Component

@Component
class UserStoreImpl(
    private val userRepository: UserRepository
) : UserStore {
    override fun store(user: User): User {
        return userRepository.save(user)
    }
}