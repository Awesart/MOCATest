package org.example.project.data.models

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserDto (
    val localUsername: String,
    val score: Float,
)