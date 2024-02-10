package navigation.contents

import Player
import PlayerListScreen
import androidx.compose.runtime.Composable
import navigation.components.PlayerListComponent

@Composable
fun PlayerListContent(component: PlayerListComponent, playerList: List<Player>, onPlayerSelected: (Player) -> Unit) {
    PlayerListScreen(playerList, onPlayerSelected)
}

