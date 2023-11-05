package jjfactory.koupang.payments.infrastructure

import jjfactory.koupang.payments.domain.Billing
import jjfactory.koupang.payments.domain.Payments
import jjfactory.koupang.payments.domain.PaymentsStore
import org.springframework.stereotype.Component

@Component
class PaymentsStoreImpl(
    private val paymentsRepository: PaymentsRepository,
    private val billingRepository: BillingRepository
) : PaymentsStore {
    override fun storeBilling(billing: Billing): Billing {
        TODO("Not yet implemented")
    }

    override fun storePayments(payments: Payments): Payments {
        TODO("Not yet implemented")
    }
}