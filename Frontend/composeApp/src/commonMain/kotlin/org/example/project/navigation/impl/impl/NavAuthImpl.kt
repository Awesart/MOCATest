package org.example.project.navigation.impl.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.commonUI.auth.Home
import org.example.project.commonUI.auth.Login
import org.example.project.navigation.impl.api.NavKeysAuth
import org.example.project.commonUI.auth.SignUp

fun EntryProviderScope<NavKey>.homeScreen(backStack:  NavBackStack<NavKey>) {

    entry<NavKeysAuth.HomeScreen> {
        Home(
            onLoginClick = {
                backStack.add(NavKeysAuth.LoginScreen)
            },
            onSignUpClick = {
                backStack.add(NavKeysAuth.SignUpScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.loginScreen(backStack:  NavBackStack<NavKey>) {

    entry<NavKeysAuth.LoginScreen> {
        Login(
            onLoginClick = {
                backStack.add(NavKeysAuth.LoginScreen)
            },
            onSignUpClick = {
                backStack.add(NavKeysAuth.SignUpScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.signUpScreen(backStack:  NavBackStack<NavKey>) {

    entry<NavKeysAuth.SignUpScreen> {
        SignUp(
            onSignUpClick = {
                backStack.add(NavKeysAuth.SignUpScreen)
            }
        )
    }

}