package jjfactory.koupang.delivery.infrastructure

import jjfactory.koupang.delivery.domain.Delivery
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryRepository : JpaRepository<Delivery, Long> {
}