package navigation

import PlayerListScreen
import allPlayers
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable


@Composable
fun RootContent() {
    Scaffold(bottomBar = { BottomBar() }) {
        PlayerListScreen(allPlayers, { })
    }
}

@Composable
fun BottomBar() {
    BottomAppBar {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Teams"
                )
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Players"
                )
            }
        )
    }
}

