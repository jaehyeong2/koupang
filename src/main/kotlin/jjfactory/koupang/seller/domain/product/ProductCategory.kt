package jjfactory.koupang.seller.domain.product

import jakarta.persistence.*


//상훔은 여러카테고리에 속할 수 있다.
//@Table(indexes = [Index(name = "code", columnList = "code")])
@Entity
class ProductCategory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
    @ManyToOne(fetch = FetchType.LAZY)
    val category: Category

)