package jjfactory.koupang.seller.domain.product

interface ProductStore {
    fun store(product: Product): Long
}