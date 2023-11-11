package jjfactory.koupang.user.infrastructure

import jjfactory.koupang.user.domain.User
import jjfactory.koupang.user.domain.UserReader
import org.slf4j.LoggerFactory
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserReaderImpl(
    private val userRepository: UserRepository
) : UserReader {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun getById(id: Long): User {
        logger.info("reader call")
        return userRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    override fun existByUsername(username: String): Boolean {
        return userRepository.existsByUsername(username)
    }

    override fun getByUsername(username: String): User {
        return userRepository.findByUsername(username) ?: throw NotFoundException()
    }

    override fun getAllUsers(): List<User>{
        return userRepository.findAll()
    }
}