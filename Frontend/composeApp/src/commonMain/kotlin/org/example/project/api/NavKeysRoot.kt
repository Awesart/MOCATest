package org.example.project.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen : NavKey

@Serializable
data object LoginScreen : NavKey

@Serializable
data object SignUpScreen : NavKey
