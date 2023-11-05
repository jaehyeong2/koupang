package jjfactory.koupang.payments.domain

interface PaymentsReader {
    fun getPaymentByKey(key: String): Payments
    fun getBillingByPaymentsId(paymentsId: Long): Billing
    fun getPaymentsById(id: Long): Payments
    fun getBillingById(id: Long): Billing
}