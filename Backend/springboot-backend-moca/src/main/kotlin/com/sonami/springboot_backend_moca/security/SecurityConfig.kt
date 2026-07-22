package com.sonami.springboot_backend_moca.security

import io.jsonwebtoken.Jwt
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.HttpSecurityDsl
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig (
    private val userDetailsService: CustomUserDetailsService,
    private val jwtEntryPoint: JWTEntryPoint
){

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http{
            csrf{disable()}

            exceptionHandling {
                authenticationEntryPoint = jwtEntryPoint
            }

            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }

            authorizeHttpRequests{
                authorize("/auth/**", permitAll)
                authorize("/user/**", hasRole("USER"))
                authorize(anyRequest, authenticated)
            }

        }

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }



    @Bean
    fun authenticationManager(
        userDetailsService: UserDetailsService,
        passwordEncoder: PasswordEncoder
    ): AuthenticationManager {
        val authenticationProvider = DaoAuthenticationProvider(userDetailsService)
        authenticationProvider.setPasswordEncoder(passwordEncoder)

        return ProviderManager(authenticationProvider)
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        val idForEncode = "bcrypt"

        val encoders: MutableMap<String, PasswordEncoder> = mutableMapOf()
        encoders[idForEncode] = BCryptPasswordEncoder()

        val pEncoder: PasswordEncoder = DelegatingPasswordEncoder(idForEncode,
            encoders)

        return pEncoder
    }

    @Bean
    fun jwtAuthenticationFilter(): JWTAuthenticationFilter{
        return JWTAuthenticationFilter()
    }

}