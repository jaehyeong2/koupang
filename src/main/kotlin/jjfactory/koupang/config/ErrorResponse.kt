package jjfactory.koupang.config

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse(
    var status: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(),
    var errorCode: String? = status.toString(),
    var exceptionType: String? = null,
    var message: String?,


)


