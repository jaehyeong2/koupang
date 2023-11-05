package jjfactory.koupang.payments.domain

interface PaymentsStore {
    fun storeBilling(billing: Billing): Billing
    fun storePayments(payments: Payments): Payments
}