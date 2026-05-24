package org.example.project.navigation.impl.ui

import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.home_and_garden
import org.example.project.navigation.impl.api.NavKeysMain
import org.jetbrains.compose.resources.DrawableResource

data class BottomItem(
    val icon: DrawableResource,
    val title: String
)

val TOP_LEVEL_DESTINATIONS = mapOf(
    NavKeysMain.MainHome to BottomItem(
        Res.drawable.home_and_garden,
        title = "Home",
    ),
)