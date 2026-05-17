package com.sonami.springboot_backend_moca.repository

import com.sonami.springboot_backend_moca.models.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsername(username: String): UserEntity?
    fun existsByUsername(username: String): Boolean

}
