package jjfactory.koupang.user.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class UserServiceImplTest(
    @Autowired
    private val userService: UserServiceImpl
) : BehaviorSpec({

    Given("정상 데이터 값으로"){
        val command = UserCommand.Create(
            name = "lee",
            username = "tester",
            address = Address(
                zipCode = "12111",
                city = "seoul",
                street = "xxx Gil"
            )
        )

        When("유저를 저장하면"){
            val result = userService.store(command)

            Then("정상 저장된다."){
                result shouldNotBe(null)
            }
        }
    }

    Given("신규 유저등록 시"){
        val command = UserCommand.Create(
            name = "lee",
            username = "tester",
            address = Address(
                zipCode = "12111",
                city = "seoul",
                street = "xxx Gil"
            )
        )

        val command2 = UserCommand.Create(
            name = "lee",
            username = "tester",
            address = Address(
                zipCode = "12111",
                city = "seoul",
                street = "xxx Gil"
            )
        )

        When("중복된 username을 저장하면"){
            userService.store(command)
            Then("익셉션이 발생"){
                shouldThrow<IllegalArgumentException> {
                    userService.store(command2)
                }
            }
        }
    }

})