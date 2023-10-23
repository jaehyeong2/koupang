package jjfactory.koupang.seller.domain.product

interface ProductReader {
    fun getById(id: Long): Product
    fun getByCode(code: String): Product
    fun getListBySellerId(sellerId: Long): List<Product>
}