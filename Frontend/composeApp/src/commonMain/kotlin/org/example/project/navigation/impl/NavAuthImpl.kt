package org.example.project.navigation.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.commonUI.auth.registerComplete.RegisterComplete
import org.example.project.navigation.ui.NavigateAuth
import org.example.project.commonUI.auth.home.Home
import org.example.project.commonUI.auth.login.Login
import org.example.project.commonUI.auth.register.SignUp
import org.example.project.navigation.api.Route

fun EntryProviderScope<NavKey>.auth(rootBackStack: NavBackStack<NavKey>){

    entry<Route.Auth> {
        NavigateAuth(rootBackStack)
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

fun EntryProviderScope<NavKey>.loginScreen(
    rootBackStack: NavBackStack<NavKey>,
    backStack:  NavBackStack<NavKey>) {

    entry<Route.Auth.LoginScreen> {
        Login(
            onLoginSuccessfulClick = {
                rootBackStack.add(Route.Main)
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