package com.sonami.springboot_backend_moca.controllers

import com.sonami.springboot_backend_moca.dto.LocalUserDto
import com.sonami.springboot_backend_moca.dto.LocalUserListDto
import com.sonami.springboot_backend_moca.dto.UserUiDto
import com.sonami.springboot_backend_moca.exceptions.UserNotFoundExceptionNoID
import com.sonami.springboot_backend_moca.models.LocalUserEntity
import com.sonami.springboot_backend_moca.models.UserEntity
import com.sonami.springboot_backend_moca.repository.LocalUserRepository
import com.sonami.springboot_backend_moca.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
    private val userRepository: UserRepository,
    private val localUserRepository: LocalUserRepository
) {

    @GetMapping("/ui")
    fun getUser(
        @AuthenticationPrincipal userDetails: UserDetails
    ): ResponseEntity<UserUiDto> {

        val username = userDetails.username

        val user: UserEntity? = userRepository.findByUsername(username)

        user ?: throw UserNotFoundExceptionNoID()

        return ResponseEntity(UserUiDto(user.username, user.email), HttpStatus.OK)
    }

    //Function that lets you add local users
    @PostMapping("/add")
    fun addLocalUser(
        @AuthenticationPrincipal userDetails: UserDetails,
        @RequestBody userDto: LocalUserDto
    ): ResponseEntity<String>{

        //Once the JWT validation passes then grab the user details
        val username = userDetails.username

        val user: UserEntity? = userRepository.findByUsername(username)

        user ?: throw UserNotFoundExceptionNoID()

        //Now add the local user using the localUserDto that is passed.

        //First check if user already exists by username.
        if(localUserRepository.existsByUsername(userDto.localUsername)){
            return ResponseEntity("The user already exists!", HttpStatus.BAD_REQUEST)
        }

        //Since it doesn't we can safely add the user.
        val localUser = LocalUserEntity(
            username = userDto.localUsername,
            score = userDto.score,
            user = user
        )

        //Save through the repository
        localUserRepository.save(localUser)

        return ResponseEntity("Local user added!", HttpStatus.OK)
    }

    //Function that returns a list of the Local Users associated with a user.
    @GetMapping("getLocal")
    fun getLocalUsers(
        @AuthenticationPrincipal userDetails: UserDetails
    ): ResponseEntity<LocalUserListDto>{

        //Grab the username from user details
        val username = userDetails.username

        //Get the User from the database
        val user: UserEntity? = userRepository.findByUsername(username)

        user ?: throw UserNotFoundExceptionNoID()

        //Next return the list of users connected to the User id.
        val localUsers =
            LocalUserListDto(localUserRepository.findByUser(user).map { localUserEntity ->
            LocalUserDto(
                localUsername = localUserEntity.username,
                score = localUserEntity.score
            )
        })

        return ResponseEntity(localUsers, HttpStatus.OK)

    }
}