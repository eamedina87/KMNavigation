package navigation.contents
import Player
import PlayerListScreen
import androidx.compose.runtime.Composable
import navigation.components.PlayerListComponent
import PlayerDetailScreen
import allPlayers
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import navigation.components.PlayersComponent
import navigation.components.PlayerDetailComponent

@Composable
fun PlayersContent(component: PlayersComponent, modifier: Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is PlayersComponent.PlayersChild.List -> PlayerListContent(child.component, allPlayers) { player ->
                child.component.onPlayerClicked(
                    player
                )
            }

            is PlayersComponent.PlayersChild.Detail -> PlayerDetailContent(child.component, child.component.player.value)
        }
    }
}

@Composable
fun PlayerListContent(component: PlayerListComponent, playerList: List<Player>, onPlayerSelected: (Player) -> Unit) {
    PlayerListScreen(playerList, onPlayerSelected)
}

@Composable
fun PlayerDetailContent(component: PlayerDetailComponent, player: Player) {
    PlayerDetailScreen(player)
}