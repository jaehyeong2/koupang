package jjfactory.koupang.user.domain

import jjfactory.koupang.system.ActivityLogRepo
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Transactional
@Component
class UserServiceImpl(
    private val userReader: UserReader,
    private val userStore: UserStore,
    private val activityLogRepo: ActivityLogRepo
) : UserService {
    private val logger = LoggerFactory.getLogger(javaClass)

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

    @Cacheable(value = ["userInfo"])
    @Transactional(readOnly = true)
    override fun getInfo(id: Long): UserInfo.Main {
        val user = userReader.getById(id)
        logger.info("service call")


        return UserInfo.Main(
            name = user.name,
            username = user.username,
            address = user.address
        )
    }

    @Cacheable(value = ["userInfo"], cacheManager = "longCacheManager")
    @Transactional(readOnly = true)
    override fun getInfo2(id: Long): UserInfo.Main {
        val user = userReader.getById(id)
        logger.info("service call")


        return UserInfo.Main(
            name = user.name,
            username = user.username,
            address = user.address
        )
    }

    @Transactional(readOnly = true)
    override fun getAllUsers(): List<UserInfo.Main> {
        return userReader.getAllUsers().map { user ->
            UserInfo.Main(
                name = user.name,
                username = user.username,
                address = user.address
            )
        }
    }


//    fun function(){
//        val map : MutableMap<Long, PostDto> = HashMap()
//
//        activityLogRepo.findAll().forEach {
//            map[it.id!!] = PostDto(it.content)
//        }
//
//        map.mapKeys {
//
//        }
//
//
//    }


}

data class PostDto(
    val content: String
)