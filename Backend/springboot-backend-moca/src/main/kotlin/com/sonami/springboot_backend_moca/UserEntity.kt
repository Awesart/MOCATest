package com.sonami.springboot_backend_moca

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @Column(nullable = false)
    val username : String,

    @Column(nullable = false)
    val password : String,

    @Column(nullable = false)
    val email : String

)