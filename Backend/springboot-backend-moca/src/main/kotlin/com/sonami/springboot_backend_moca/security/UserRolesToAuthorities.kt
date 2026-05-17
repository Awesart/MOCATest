package com.sonami.springboot_backend_moca.security

import com.sonami.springboot_backend_moca.models.Roles
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority


/*
Personal note
If something is an interface you can't instantiate it.
Instead, you have to either define your own class that extends the interface.
Or use one that is already provided by the framework.
*/
fun rolesToGrantedAuthority(
    roles: MutableSet<Roles>
): MutableCollection<GrantedAuthority>{

    val grantedAuthorities: MutableCollection<GrantedAuthority> = roles
        .map {
        SimpleGrantedAuthority( it.name)
    }
        .toMutableList()

    return grantedAuthorities

}