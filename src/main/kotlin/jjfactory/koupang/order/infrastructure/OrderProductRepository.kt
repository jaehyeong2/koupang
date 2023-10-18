package jjfactory.koupang.order.infrastructure

import jjfactory.koupang.order.domain.OrderProduct
import org.springframework.data.jpa.repository.JpaRepository

interface OrderProductRepository : JpaRepository<OrderProduct, Long> {
}