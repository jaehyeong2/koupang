package jjfactory.koupang.seller.infrastructure.product

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jjfactory.koupang.seller.domain.Seller
import jjfactory.koupang.seller.domain.product.Product
import jjfactory.koupang.seller.domain.product.ProductReview
import jjfactory.koupang.user.domain.Address
import jjfactory.koupang.user.domain.User
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class ProductReviewDslRepoTest {
    @PersistenceContext
    lateinit var entityManager: EntityManager

    @Autowired
    lateinit var productReviewDslRepo: ProductReviewDslRepo

    @Transactional
    @Test
    fun `유저아이디로 정상 조회`() {
        val user = User(
            name = "lee",
            username = "testet",
            address = Address(
                zipCode = "12111",
                city = "seoul",
                street = "xxx Gil"
            )
        )

        entityManager.persist(user)

        val seller = Seller(
            name = "seller",
            bizNum = "123",
            key = "key"
        )

        entityManager.persist(seller)

        val product = Product(
            seller = seller,
            name = "product",
            code = "code"
        )

        entityManager.persist(product)

        val productReview = ProductReview(
            product = product,
            userId = user.id!!,
            content = ""
        )

        entityManager.persist(productReview)

        val list = productReviewDslRepo.getReviewsByUserId(user.id!!)

        Assertions.assertThat(list).isNotEmpty
    }
}