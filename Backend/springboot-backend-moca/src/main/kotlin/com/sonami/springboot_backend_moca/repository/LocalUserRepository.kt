package com.sonami.springboot_backend_moca.repository

import com.sonami.springboot_backend_moca.models.LocalUserEntity
import com.sonami.springboot_backend_moca.models.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LocalUserRepository : JpaRepository<LocalUserEntity, Long> {

    fun existsByUsername(username: String): Boolean

    fun findByUser(userEntity: UserEntity): List<LocalUserEntity>
}