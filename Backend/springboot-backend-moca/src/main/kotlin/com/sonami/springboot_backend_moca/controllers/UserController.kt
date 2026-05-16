package com.sonami.springboot_backend_moca.controllers

import com.sonami.springboot_backend_moca.dto.UserDto
import com.sonami.springboot_backend_moca.service.UserService
import com.sonami.springboot_backend_moca.toEntity
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
    private val userService: UserService,
    private val authenticationManager: AuthenticationManager
){

    @GetMapping
    fun getUser(
        userDto: UserDto
    ): UserDto{
        return userService.getUser(userDto)
    }

    @PostMapping
    fun addUser(
       @RequestBody userDto: UserDto
    ){
        userService.addUser(userDto)
    }

    @PostMapping("/login")
    fun login(@RequestBody userDto: UserDto) {
        val authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
            userDto.username, userDto.password
        )
        val authenticationResponse = authenticationManager.authenticate(authenticationRequest)
    }

    @PutMapping
    fun updateUser(
        userDto: UserDto
    ){

    }


}