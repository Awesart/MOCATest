package com.sonami.springboot_backend_moca.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.domain.Score

@Entity
@Table(name = "localUsers")
data class LocalUserEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val username: String ="",

    @Column(nullable = false)
    val score: Float = 0.0f,

)