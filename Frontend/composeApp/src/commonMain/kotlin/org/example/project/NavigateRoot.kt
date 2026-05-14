package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.api.HomeScreen
import org.example.project.api.LoginScreen
import org.example.project.api.SignUpScreen
import org.example.project.impl.homeScreen
import org.example.project.impl.loginScreen
import org.example.project.impl.signUpScreen


private val config = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(HomeScreen::class, HomeScreen.serializer())
            subclass(LoginScreen::class, LoginScreen.serializer())
            subclass(SignUpScreen::class, SignUpScreen.serializer())
        }
    }
}

@Composable
fun NavigateRoot() {

    val backStack = rememberNavBackStack(config, HomeScreen)

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
