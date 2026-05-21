package com.sonami.springboot_backend_moca.dto

data class AuthDto(
    val accessToken: String,
    val tokenType: String
)