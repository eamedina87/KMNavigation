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
import PlayerDetailScreen
import TeamDetailScreen
import TeamListScreen
import allTeams
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun RootContent() {
    val navigator = rememberNavigator()
    Scaffold(bottomBar = { BottomBar() }) {
        NavHost(
            navigator = navigator,
            initialRoute = "/teams",
            ) {
            scene("/teams") {
                TeamListScreen(allTeams, { //Todo go to team detail
                    navigator.navigate("/teams/${it.name}")
                })
            }
                scene("/teams/{id}") { backstackEntry ->
                    //val teamId = backstackEntry.path<String>("id") ?: allTeams.random().name
                    val team = allTeams.random()//allTeams.find { it.name == teamId } ?: allTeams.random()
                    val players = allPlayers.filter { it.team == team.name }
                    TeamDetailScreen(team, players, { //todo navigate to player detail
                        navigator.navigate("/teams/${it.name}")
                    })
                }
                scene("/players") {
                    PlayerListScreen(allPlayers, {
                        navigator.navigate("/players/${it.name}")
                    })
                }
                scene("/players/{id}") { backstackEntry ->
                    val playerId = allPlayers.random().name//backstackEntry.path<String>("id") ?: allPlayers.random().name
                    val player = allPlayers.find { it.name == playerId } ?: allPlayers.random()
                    PlayerDetailScreen(player)
                }
        }
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

