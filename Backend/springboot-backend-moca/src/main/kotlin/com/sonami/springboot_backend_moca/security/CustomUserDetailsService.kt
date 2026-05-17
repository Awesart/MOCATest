package com.sonami.springboot_backend_moca.security

import com.sonami.springboot_backend_moca.exceptions.UserNotFoundException
import com.sonami.springboot_backend_moca.exceptions.UserNotFoundExceptionNoID
import com.sonami.springboot_backend_moca.models.UserEntity
import com.sonami.springboot_backend_moca.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService : UserDetailsService {

    lateinit var userRepository : UserRepository

    @Autowired
    fun prepare(
        userRepository: UserRepository
    ){
        this.userRepository = userRepository
    }


    /*
    Overriding the function allows us to search through our JDBC database rather than using
    the dummy implementation that was given in the documentation.
    */
    override fun loadUserByUsername(username: String): UserDetails {
        val user: UserEntity? = userRepository.findByUsername(username)

         user ?: throw UserNotFoundExceptionNoID()

        return User(user.username, user.password, rolesToGrantedAuthority(user.roles))

    }


}