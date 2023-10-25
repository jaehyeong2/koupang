package jjfactory.koupang.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients("jjfactory.koupang.external.openFeign")
class OpenFeignConfig {
}