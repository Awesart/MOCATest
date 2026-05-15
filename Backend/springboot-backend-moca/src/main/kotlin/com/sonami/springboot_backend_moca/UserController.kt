package com.sonami.springboot_backend_moca

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
        userService.getUser(userDto.id)
    }

    @PostMapping
    fun addUser(
        userDto: UserDto
    ){
        userService.addUser(userDto)
    }

    @PutMapping
    fun updateUser(
        userDto: UserDto
    ){
        userService.updateUser(userDto)
    }

    @DeleteMapping
    fun deleteUser(
        userDto: UserDto
    ){
        userService.deleteUser(userDto.id)
    }

}