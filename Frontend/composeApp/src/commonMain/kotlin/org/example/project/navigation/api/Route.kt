package org.example.project.navigation.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {

    @Serializable
    data object Auth: Route, NavKey{

        @Serializable
        data object HomeScreen : Route
        @Serializable
        data object LoginScreen : Route

        @Serializable
        data object SignUpScreen : Route

        @Serializable
        data object SignUpCompleteScreen : Route
    }


    @Serializable
    data object Main: Route, NavKey{
        @Serializable
        data object MainHome: Route

        @Serializable
        data object Test: Route

        @Serializable
        data object Stats: Route

        @Serializable
        data object Settings: Route

    }

}