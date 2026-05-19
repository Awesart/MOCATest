package com.sonami.springboot_backend_moca.security

import com.sonami.springboot_backend_moca.exceptions.UserNotAuthorizedJWT
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JWTGenerator(
) {

    fun generateToken(
        authentication: Authentication
    ): String{
        val userName: String? = authentication.name
        val currentDate = Date()
        val expirationDate: Date = Date(currentDate.time + SecurityConstants.JWT_EXPIRATION)

        val token: String = Jwts.builder()
            .subject(userName)
            .issuedAt(currentDate)
            .expiration(expirationDate)
            .signWith(SecurityConstants.secretKey)
            .compact()

        return token
    }

    fun getUsernameFromToken(
        token: String?
    ): String{
        val userName = Jwts.parser()
            .verifyWith(SecurityConstants.secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
            .subject

        return userName
    }

    fun validateToken(
        token: String?
    ): Boolean{
        try{
            Jwts.parser()
                .verifyWith(SecurityConstants.secretKey)
                .build()
                .parseSignedClaims(token)

            return true
        }
        catch(ex: JwtException){
            throw UserNotAuthorizedJWT(ex)
        }
    }

}