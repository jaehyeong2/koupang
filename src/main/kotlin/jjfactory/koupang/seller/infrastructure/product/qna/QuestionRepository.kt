package jjfactory.koupang.seller.infrastructure.product.qna

import jjfactory.koupang.seller.domain.product.qna.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long> {
}