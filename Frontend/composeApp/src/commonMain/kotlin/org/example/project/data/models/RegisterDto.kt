package org.example.project.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterDto (
    val username: String,
    val password: String,
    val email: String
)