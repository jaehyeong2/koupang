package jjfactory.koupang.seller.domain.product

class ProductInfo {
    data class Main(
        val id: Long,
        val sellerId: Long,
        val name: String,
        val code: String,
        val qty: Int
    )
}