package navigation

import Player
import PlayerDetailNode
import PlayersListNode
import allPlayers
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.navigation.composable.AppyxComponent
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.ParentNode
import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

class PlayersNode(
    context: BuildContext,
    private val backstack: BackStack<PlayerNav> = BackStack(
        model = BackStackModel(
            initialTarget = PlayerNav.PlayerList,
            savedStateMap = context.savedStateMap
        ),
        visualisation = { BackStackFader(it) }
    )
) : ParentNode<PlayersNode.PlayerNav>(
    buildContext = context,
    appyxComponent = backstack
) {

    sealed class PlayerNav : Parcelable {
        @Parcelize data object PlayerList : PlayerNav()
        @Parcelize data class PlayerDetail(val player: Player) : PlayerNav()
    }

    @Composable
    override fun View(modifier: Modifier) {
        AppyxComponent(
            appyxComponent = backstack,
            modifier = modifier
        )
    }

    override fun resolve(interactionTarget: PlayerNav, buildContext: BuildContext): Node =
        when (interactionTarget) {
            is PlayerNav.PlayerList -> PlayersListNode(buildContext, allPlayers) { backstack.push(PlayerNav.PlayerDetail(it)) }
            is PlayerNav.PlayerDetail -> PlayerDetailNode(buildContext, interactionTarget.player)
        }

}
