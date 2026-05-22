package org.example.project.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.api.ClientAPI
import org.example.project.commonUI.auth.Home
import org.example.project.commonUI.auth.Login
import org.example.project.api.HomeScreen
import org.example.project.api.LoginScreen
import org.example.project.api.SignUpScreen
import org.example.project.commonUI.auth.SignUp

fun EntryProviderScope<NavKey>.homeScreen(backStack:  NavBackStack<NavKey>) {

    entry<HomeScreen> {
        Home(
            onLoginClick = {
                backStack.add(LoginScreen)
            },
            onSignUpClick = {
                backStack.add(SignUpScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.loginScreen(backStack:  NavBackStack<NavKey>) {

    entry<LoginScreen> {
        Login(
            onLoginClick = {
                val client: ClientAPI = ClientAPI()



                backStack.add(LoginScreen)
            },
            onSignUpClick = {
                backStack.add(SignUpScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.signUpScreen(backStack:  NavBackStack<NavKey>) {

    entry<SignUpScreen> {
        SignUp(
            onSignUpClick = {
                backStack.add(SignUpScreen)
            }
        )
    }

}