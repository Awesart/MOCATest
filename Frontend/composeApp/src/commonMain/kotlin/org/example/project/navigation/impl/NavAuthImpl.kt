package org.example.project.navigation.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.commonUI.Auth.registerComplete.RegisterComplete
import org.example.project.navigation.ui.NavigateAuth
import org.example.project.commonUI.auth.Home
import org.example.project.commonUI.auth.Login
import org.example.project.commonUI.auth.SignUp
import org.example.project.navigation.api.Route
import org.example.project.navigation.ui.NavigateMain

fun EntryProviderScope<NavKey>.auth(){

    entry<Route.Auth> {
        NavigateAuth()
    }

}

fun EntryProviderScope<NavKey>.homeScreen(backStack:  NavBackStack<NavKey>) {

    entry<Route.Auth.HomeScreen> {
        Home(
            onLoginClick = {
                backStack.add(Route.Auth.LoginScreen)
            },
            onSignUpClick = {
                backStack.add(Route.Auth.SignUpScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.loginScreen(backStack:  NavBackStack<NavKey>) {

    entry<Route.Auth.LoginScreen> {
        Login(
            onLoginSuccessfulClick = {
                backStack.add(Route.Auth.LoginScreen)
            },
            onSignUpClick = {
                backStack.add(Route.Auth.SignUpScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.signUpScreen(backStack:  NavBackStack<NavKey>) {

    entry<Route.Auth.SignUpScreen> {
        SignUp(
            onSignUpClick = {
                backStack.add(Route.Auth.SignUpCompleteScreen)
            }
        )
    }

}

fun EntryProviderScope<NavKey>.signUpCompleteScreen(backStack: NavBackStack<NavKey>){

    entry<Route.Auth.SignUpCompleteScreen> {
        RegisterComplete(
            onContinue = {
                backStack.add(Route.Auth.LoginScreen)
            }
        )
    }

}