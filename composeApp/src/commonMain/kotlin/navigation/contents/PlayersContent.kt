package navigation.contents
import PlayerListScreen
import androidx.compose.runtime.Composable
import PlayerDetailScreen
import allPlayers
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import navigation.components.PlayersComponent

@Composable
fun PlayersContent(component: PlayersComponent, modifier: Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is PlayersComponent.PlayersChild.List -> PlayerListScreen(allPlayers, { player -> child.component.onPlayerClicked(player)})
            is PlayersComponent.PlayersChild.Detail -> PlayerDetailScreen(child.component.player.value)
        }
    }
}