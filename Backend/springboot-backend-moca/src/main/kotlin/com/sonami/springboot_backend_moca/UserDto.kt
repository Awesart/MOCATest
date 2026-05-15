package com.sonami.springboot_backend_moca


data class UserDto (
    val id : Long,
    val username : String,
    val password : String,
    val email : String
)