package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.navigation.impl.api.NavKeysAuth
import org.example.project.navigation.impl.impl.homeScreen
import org.example.project.navigation.impl.impl.loginScreen
import org.example.project.navigation.impl.impl.signUpScreen


private val config = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(NavKeysAuth.HomeScreen::class, NavKeysAuth.HomeScreen.serializer())
            subclass(NavKeysAuth.LoginScreen::class, NavKeysAuth.LoginScreen.serializer())
            subclass(NavKeysAuth.SignUpScreen::class, NavKeysAuth.SignUpScreen.serializer())
        }
    }
}

@Composable
fun NavigateAuth() {

    val backStack = rememberNavBackStack(config, NavKeysAuth.HomeScreen)

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
