package jjfactory.koupang.seller.domain.product

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class ProductServiceImpl(
    private val productReader: ProductReader,
    private val productStore: ProductStore
) : ProductService {

    @Transactional(readOnly = true)
    override fun getById(id: Long): ProductInfo.Main {
        TODO("Not yet implemented")
    }

    override fun save(command: ProductCommand.Create): Long {
        TODO("Not yet implemented")
    }

    override fun modify(command: ProductCommand.Modify): Long {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}