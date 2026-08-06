package com.sonami.springboot_backend_moca.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.data.domain.Score

@Entity
@Table(name = "localUsers")
class LocalUserEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val username: String ="",

    @Column(nullable = false)
    val score: Float = 0.0f,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: UserEntity? = null

)