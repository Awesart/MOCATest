package com.sonami.springboot_backend_moca.repository

import com.sonami.springboot_backend_moca.models.Roles
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Roles, Long> {

    fun findByName(role: String): Roles?
}