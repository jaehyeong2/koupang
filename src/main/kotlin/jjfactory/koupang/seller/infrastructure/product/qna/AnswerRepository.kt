package jjfactory.koupang.seller.infrastructure.product.qna

import jjfactory.koupang.seller.domain.product.Category
import jjfactory.koupang.seller.domain.product.qna.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long> {
}