package jjfactory.koupang.seller.domain.product

interface ProductService {
    fun getById(id: Long): ProductInfo.Main
    fun save(command: ProductCommand.Create): Long
    fun modify(command: ProductCommand.Modify): Long
    fun delete(id: Long)
}