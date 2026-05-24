package org.example.project.navigation.impl.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavKeysAuth: NavKey {

    @Serializable
    data object HomeScreen : NavKeysAuth
    @Serializable
    data object LoginScreen : NavKeysAuth

    @Serializable
    data object SignUpScreen : NavKeysAuth

}