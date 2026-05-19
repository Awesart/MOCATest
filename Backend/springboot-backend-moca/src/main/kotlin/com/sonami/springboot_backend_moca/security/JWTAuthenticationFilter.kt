package com.sonami.springboot_backend_moca.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter

class JWTAuthenticationFilter: OncePerRequestFilter() {

    @Autowired
    lateinit var jwtGenerator: JWTGenerator

    @Autowired
    lateinit var customUserDetailsService: CustomUserDetailsService


    override fun doFilterInternal(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        filterChain: FilterChain?
    ) {
        val token: String? = getJWTFromRequest(request)

        if(StringUtils.hasText(token) && jwtGenerator.validateToken(token) ){

            //Loads from the bearer token
            val username: String = jwtGenerator.getUsernameFromToken(token)

            //Loads from the repository
            val userDetails: UserDetails = customUserDetailsService.loadUserByUsername(username)

            //Authentication token's details get built
            val authenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)

            //SecurityContextHolder's authentication grabs whether the user is authenticated or not
            SecurityContextHolder.getContext().authentication = authenticationToken

        }

        //Move down/up the filter.
        filterChain?.doFilter(request, response)
    }

    fun getJWTFromRequest(
        request: HttpServletRequest?
    ): String?{
        val authHeaderValue = request?.getHeader("Authorization")

        if(authHeaderValue != null && authHeaderValue.startsWith("Bearer")){
            val token: String = authHeaderValue.substring(7, authHeaderValue.length)
            return token
        }

        return null
    }

}