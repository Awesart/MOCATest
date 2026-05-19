package com.sonami.springboot_backend_moca.exceptions

class UserNotFoundException (
    private val id : Long
): RuntimeException(
    "A user with $id is not found."
)

class UserNotFoundExceptionNoID : RuntimeException(
    "User cannot be not found."
)