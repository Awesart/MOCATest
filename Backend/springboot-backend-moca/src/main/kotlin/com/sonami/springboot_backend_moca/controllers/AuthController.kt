package com.sonami.springboot_backend_moca.controllers

import com.sonami.springboot_backend_moca.dto.AuthDto
import com.sonami.springboot_backend_moca.dto.LoginRequest
import com.sonami.springboot_backend_moca.dto.RegisterDto
import com.sonami.springboot_backend_moca.models.Roles
import com.sonami.springboot_backend_moca.models.UserEntity
import com.sonami.springboot_backend_moca.repository.RoleRepository
import com.sonami.springboot_backend_moca.repository.UserRepository
import com.sonami.springboot_backend_moca.security.JWTGenerator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val jwtGenerator: JWTGenerator
){

    @PostMapping("/login")
    fun login(
        @RequestBody loginRequest: LoginRequest
    ): ResponseEntity<AuthDto> {

        val authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
            loginRequest.username, loginRequest.password
        )

        val authenticationResponse: Authentication = authenticationManager.authenticate(authenticationRequest)

        val token: String = jwtGenerator.generateToken(authenticationResponse)

        SecurityContextHolder.getContext().authentication = authenticationResponse

        val jwtToken: AuthDto = AuthDto(token, "Bearer ")

        return ResponseEntity(jwtToken, HttpStatus.OK)
    }


    @PostMapping("/register")
    fun register(
        @RequestBody registerDto: RegisterDto
    ): ResponseEntity<String> {

        //Can't register a user with a username that already exists
        if(userRepository.existsByUsername(registerDto.username)){
            return ResponseEntity("Username already exists!", HttpStatus.BAD_REQUEST)
        }

        //Every user that registers gets the USER role.
        val role: Roles = roleRepository.findByName("USER") ?: return ResponseEntity(
            "Default USER role not found", HttpStatus.INTERNAL_SERVER_ERROR
        )

        val roles = mutableSetOf<Roles>(role)

        val user = UserEntity(
            username = registerDto.username,
            password = passwordEncoder.encode(registerDto.password),
            email = registerDto.email,
            roles = roles
        )

        //Saves the user to the database
        userRepository.save(user)

        return ResponseEntity("Registration successful!", HttpStatus.OK)

    }


}