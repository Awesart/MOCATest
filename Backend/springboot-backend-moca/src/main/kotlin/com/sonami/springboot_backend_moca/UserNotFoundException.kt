package com.sonami.springboot_backend_moca

class UserNotFoundException (
    private val id : Long
): RuntimeException(
    "A user with $id is not found."
)