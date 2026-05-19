package com.sonami.springboot_backend_moca.exceptions

import io.jsonwebtoken.JwtException

class UserNotAuthorizedJWT(
    private val ex: JwtException
): RuntimeException (
    "User failed to authorize because of $ex"
)