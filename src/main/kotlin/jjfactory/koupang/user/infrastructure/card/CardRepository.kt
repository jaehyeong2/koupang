package jjfactory.koupang.user.infrastructure.card;

import jjfactory.koupang.user.domain.card.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<Card, Long> {
}