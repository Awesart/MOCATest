package org.example.project.navigation.impl.api

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavKeysMain {

    @Serializable
    data object MainHome: NavKeysMain

    @Serializable
    data object Test: NavKeysMain

    @Serializable
    data object Stats: NavKeysMain

    @Serializable
    data object Settings: NavKeysMain

}