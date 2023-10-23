package jjfactory.koupang.seller.domain.product.qna

import jakarta.persistence.*

@Entity
class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @ManyToOne(fetch = FetchType.LAZY)
    val question: Question,

    val content: String,
)