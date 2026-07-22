package org.example.project.data.models

import kotlinx.serialization.Serializable

@Serializable
data class JWTRequest (
    val token: String
)