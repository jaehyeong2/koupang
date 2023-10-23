package jjfactory.koupang.seller.infrastructure.product

import jjfactory.koupang.seller.domain.product.Product
import jjfactory.koupang.seller.domain.product.ProductStore
import org.springframework.stereotype.Component

@Component
class ProductStoreImpl(
    private val productRepository: ProductRepository
) : ProductStore {
    override fun store(product: Product): Long {
        return productRepository.save(product).id!!
    }
}