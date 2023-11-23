package jjfactory.koupang.config

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.AuthenticationEntryPoint

class AuthEntryPoint : AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        val auth = SecurityContextHolder.getContext().authentication
//        val isLoggedIn = auth != null && auth.isAuthenticated && auth is ManagerAuthentication

//        val status = if (isLoggedIn) HttpStatus.FORBIDDEN else HttpStatus.UNAUTHORIZED
        val status = HttpStatus.FORBIDDEN

        val errorResponse = ErrorResponse(
            status = status.value(),
//            errorCode = if (isLoggedIn) ExceptionVocab.FORBIDDEN_OBJECT.code else ExceptionVocab.AUTH_INVALID_ACCESS_TOKEN.code,
            errorCode = null,
//            message = if (isLoggedIn) ExceptionVocab.FORBIDDEN_OBJECT.description else ExceptionVocab.AUTH_INVALID_ACCESS_TOKEN.description,
            message = null
        )

        response?.contentType = "application/json;charset=UTF-8"
        response?.status = status.value()
        response?.writer?.write(ObjectMapper().writeValueAsString(errorResponse))
    }
}