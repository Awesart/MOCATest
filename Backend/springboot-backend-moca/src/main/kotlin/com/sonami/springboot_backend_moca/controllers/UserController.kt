package com.sonami.springboot_backend_moca.controllers

import com.sonami.springboot_backend_moca.dto.UserDto
import com.sonami.springboot_backend_moca.service.UserService
import com.sonami.springboot_backend_moca.toEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
    private val userService: UserService
){

    @GetMapping
    fun getUser(
        userDto: UserDto
    ){
        userService.getUser(userDto)
    }

    @PostMapping
    fun addUser(
        userDto: UserDto
    ){
        userService.addUser(userDto)
    }




}