package com.sonami.springboot_backend_moca.controllers

import com.sonami.springboot_backend_moca.dto.AuthDto
import com.sonami.springboot_backend_moca.dto.UserUiDto
import com.sonami.springboot_backend_moca.exceptions.UserNotFoundExceptionNoID
import com.sonami.springboot_backend_moca.models.UserEntity
import com.sonami.springboot_backend_moca.repository.RoleRepository
import com.sonami.springboot_backend_moca.repository.UserRepository
import com.sonami.springboot_backend_moca.security.JWTGenerator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    private val userRepository: UserRepository,
) {

    @GetMapping("/userUi")
    fun getUser(
        authentication: Authentication
    ): ResponseEntity<UserUiDto> {

        val username = authentication.name

        val user: UserEntity? = userRepository.findByUsername(username)

        user ?: throw UserNotFoundExceptionNoID()

        return ResponseEntity(UserUiDto(user.username, user.email), HttpStatus.OK)
    }
}