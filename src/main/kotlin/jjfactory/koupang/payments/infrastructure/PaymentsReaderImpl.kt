package jjfactory.koupang.payments.infrastructure

import jjfactory.koupang.payments.domain.Billing
import jjfactory.koupang.payments.domain.Payments
import jjfactory.koupang.payments.domain.PaymentsReader
import org.springframework.stereotype.Component

@Component
class PaymentsReaderImpl(
    private val paymentsRepository: PaymentsRepository,
    private val billingRepository: BillingRepository
) : PaymentsReader {
    override fun getPaymentByKey(key: String): Payments {
        TODO("Not yet implemented")
    }

    override fun getBillingByPaymentsId(paymentsId: Long): Billing {
        TODO("Not yet implemented")
    }

    override fun getPaymentsById(id: Long): Payments {
        TODO("Not yet implemented")
    }

    override fun getBillingById(id: Long): Billing {
        TODO("Not yet implemented")
    }
}