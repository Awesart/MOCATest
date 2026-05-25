package org.example.project.navigation.ui

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.navigation.api.Route
import org.example.project.navigation.impl.homeScreen
import org.example.project.navigation.impl.loginScreen
import org.example.project.navigation.impl.signUpScreen


private val config = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(Route.Auth.HomeScreen::class, Route.Auth.HomeScreen.serializer())
            subclass(Route.Auth.LoginScreen::class,Route.Auth.LoginScreen.serializer())
            subclass(Route.Auth.SignUpScreen::class, Route.Auth.SignUpScreen.serializer())
        }
    }
}

@Composable
fun NavigateAuth() {

    val backStack = rememberNavBackStack(config, Route.Auth.HomeScreen)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            homeScreen(backStack)
            loginScreen(backStack)
            signUpScreen(backStack)
        }
    )

}
