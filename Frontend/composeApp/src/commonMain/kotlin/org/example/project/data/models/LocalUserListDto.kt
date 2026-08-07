package org.example.project.data.models

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserListDto (
    val list: List<LocalUserDto>
)