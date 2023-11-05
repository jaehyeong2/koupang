package jjfactory.koupang.external.openFeign

import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping

@Component
@FeignClient(name = "ExchangeRateOpenFeign", url = "open-api.kakaopay.com")
interface KakaoPaymentsFeign {
    @PostMapping("/online/v1/payment/ready", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @Headers("Authorization: secret-key")
    fun pay()

}