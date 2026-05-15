package com.sonami.springboot_backend_moca

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class UserExceptionHandler {

    @ExceptionHandler
    fun onUserNotFound(e: UserNotFoundException) = mapOf(
        "errorCode" to "USER_NOT_FOUND",
        "message" to e.message
    )

}