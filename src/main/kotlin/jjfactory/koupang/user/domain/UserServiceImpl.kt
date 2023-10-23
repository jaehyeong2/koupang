package jjfactory.koupang.user.domain

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Transactional
@Component
class UserServiceImpl(
    private val userReader: UserReader,
    private val userStore: UserStore
) : UserService {
    override fun store(command: UserCommand.Create): Long {
        if(userReader.existByUsername(command.username)){
            throw IllegalArgumentException("유저네임 중복")
        }

        return userStore.store(command.toEntity()).id!!
    }

    override fun modify(id: Long, command: UserCommand.Modify): Long {
        val user = userReader.getById(id)
        user.modify(command.username, command.address)
        return user.id!!
    }

    @Transactional(readOnly = true)
    override fun getInfo(id: Long): UserInfo.Main {
        val user = userReader.getById(id)

        return UserInfo.Main(
            name = user.name,
            username = user.username,
            address = user.address
        )
    }
}