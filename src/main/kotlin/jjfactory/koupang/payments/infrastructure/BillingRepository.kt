package jjfactory.koupang.payments.infrastructure

import jjfactory.koupang.payments.domain.Billing
import org.springframework.data.jpa.repository.JpaRepository

interface BillingRepository : JpaRepository<Billing, Long>{
}