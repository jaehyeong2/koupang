package jjfactory.koupang.payments.infrastructure

import jjfactory.koupang.payments.domain.Payments
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentsRepository : JpaRepository<Payments, Long> {
}