//package jjfactory.koupang.payments.domain
//
//import jjfactory.koupang.external.openFeign.KakaoPaymentsFeign
//import org.springframework.stereotype.Component
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//class PaymentsServiceImpl(
//    private val kakaoPaymentsFeign: KakaoPaymentsFeign
//) : PaymentsService {
//
//    @PostMapping("/test")
//    override fun payments() {
//        kakaoPaymentsFeign.pay()
//    }
//}