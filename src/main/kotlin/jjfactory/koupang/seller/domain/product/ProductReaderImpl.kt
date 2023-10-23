package jjfactory.koupang.seller.domain.product

import jjfactory.koupang.seller.infrastructure.product.ProductRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductReaderImpl(
    private val productRepository: ProductRepository
) : ProductReader {
    override fun getById(id: Long): Product {
        return productRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    override fun getByCode(code: String): Product {
        return productRepository.findByCode(code) ?: throw NotFoundException()
    }

    override fun getListBySellerId(sellerId: Long): List<Product> {
        return productRepository.findAllBySellerId(sellerId)
    }
}