package jjfactory.koupang.order.infrastructure

import jjfactory.koupang.order.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
}