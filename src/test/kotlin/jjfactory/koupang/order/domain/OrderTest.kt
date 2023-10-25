package jjfactory.koupang.order.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.BehaviorSpec

class OrderTest: BehaviorSpec({

    Given("이미 상품이 출고된 주문은"){
        val order = Order(
            userId = 1L,
            key = "testKey",
            totalAmounts = 10000,
            status = OrderStatus.SHIPPED
        )

        When("출고를 진행할시"){
            Then("익셉션이 발생한다"){
                io.kotest.assertions.throwables.shouldThrow<IllegalArgumentException> {
                    order.startShipping()
                }
            }
        }

        When("주문을 취소할시"){
            Then("익셉션이 발생한다"){
                io.kotest.assertions.throwables.shouldThrow<IllegalArgumentException> {
                    order.cancel()
                }
            }
        }
    }

    Given("주문 생성시"){
        val order = Order(
            userId = 1L,
            key = "testKey",
            totalAmounts = 10000
        )

        val order2 = Order(
            userId = 1L,
            key = "testKey",
            totalAmounts = 10000
        )

        When("출고를 진행할시"){
            Then("정상 출고 처리 된다"){
                shouldNotThrow<Exception> { order.startShipping() }
            }
        }

        When("주문을 취소할시"){
            Then("정상 취소처리 된다."){
                shouldNotThrow<Exception> { order2.cancel() }
            }
        }

    }
})