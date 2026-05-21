package com.sonami.springboot_backend_moca.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import javax.crypto.SecretKey

object SecurityConstants {
    const val JWT_EXPIRATION = 70_000
}