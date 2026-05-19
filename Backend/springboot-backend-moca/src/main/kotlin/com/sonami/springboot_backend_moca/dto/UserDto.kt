package com.sonami.springboot_backend_moca.dto

data class UserDto (
    val id: Long,
    val username: String,
    val password: String?,
    val email: String
)