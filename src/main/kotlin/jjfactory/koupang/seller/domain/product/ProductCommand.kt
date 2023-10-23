package jjfactory.koupang.seller.domain.product

class ProductCommand {
    data class Create(
        val categoryIds: Set<Long>,
        val sellerId: Long,
        val name: String,
        val qty: Int
    )

    data class Modify(
        val categoryIds: Set<Long>,
        val sellerId: Long,
        val name: String,
        val qty: Int
    )
}