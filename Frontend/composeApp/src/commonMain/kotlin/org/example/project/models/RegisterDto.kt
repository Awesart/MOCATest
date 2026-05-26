package org.example.project.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterDto (
    val username: String,
    val password: String,
    val email: String
)