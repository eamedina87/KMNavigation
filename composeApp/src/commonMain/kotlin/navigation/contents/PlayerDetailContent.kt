package navigation.contents

import Player
import PlayerDetailScreen
import androidx.compose.runtime.Composable
import navigation.components.PlayerDetailComponent


@Composable
fun PlayerDetailContent(component: PlayerDetailComponent, player: Player) {
    PlayerDetailScreen(player)
}