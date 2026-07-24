package org.example.project.data.models

import kotlinx.serialization.Serializable

@Serializable
data class UserUiDto (
    val username: String,
    val email: String
)