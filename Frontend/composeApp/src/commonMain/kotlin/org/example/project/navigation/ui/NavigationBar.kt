package org.example.project.navigation.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainNavigationBar(
    selectedKey: NavKey,
    onSelectedKey: (NavKey) -> Unit,
    modifier: Modifier = Modifier
){
    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { (topLevelDestination, data) ->
            NavigationBarItem(
                selected = topLevelDestination == selectedKey,
                onClick = {
                    onSelectedKey(selectedKey)
                },
                icon = {
                    Icon(
                        painter = painterResource(data.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = data.title
                    )
                },
            )
        }

    }

}