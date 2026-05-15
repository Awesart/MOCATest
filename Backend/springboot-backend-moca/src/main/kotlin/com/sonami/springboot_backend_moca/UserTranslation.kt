package com.sonami.springboot_backend_moca

import com.sonami.springboot_backend_moca.dto.UserDto

fun UserDto.toEntity() : UserEntity{
    return UserEntity(
        username = this.username,
        password = this.password,
        email = this.email
    )
}

fun UserEntity.toDTO(): UserDto{
    return UserDto(
        id = this.id,
        username = this.username,
        password = this.password,
        email = this.email
    )
}