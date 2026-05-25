package org.example.project.navigation.ui

import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.assignment
import loginscreentest.composeapp.generated.resources.chart_pie_alt_svgrepo_com
import loginscreentest.composeapp.generated.resources.home_and_garden
import loginscreentest.composeapp.generated.resources.settings
import org.example.project.navigation.api.Route
import org.jetbrains.compose.resources.DrawableResource

data class BottomItem(
    val icon: DrawableResource,
    val title: String
)

val TOP_LEVEL_DESTINATIONS = mapOf(
    Route.Main.MainHome to BottomItem(
        Res.drawable.home_and_garden,
        title = "Home",
    ),
    Route.Main.Test to BottomItem(
        Res.drawable.assignment,
        title = "Test"
    ),
    Route.Main.Stats to BottomItem(
        Res.drawable.chart_pie_alt_svgrepo_com,
        title = "Stats"
    ),
    Route.Main.Settings to BottomItem(
        Res.drawable.settings,
        title = "Settings"
    ),


)