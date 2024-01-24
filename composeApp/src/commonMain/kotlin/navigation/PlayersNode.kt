package navigation

import Player
import PlayerDetailNode
import PlayersListNode
import allPlayers
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.operation.pop
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.navigation.composable.AppyxComponent
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.ParentNode
import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
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

    private val topBarTitle: MutableState<String> = mutableStateOf("Players")

    sealed class PlayerNav : Parcelable {
        @Parcelize data object PlayerList : PlayerNav()
        @Parcelize data class PlayerDetail(val player: Player) : PlayerNav()
    }

    @Composable
    override fun View(modifier: Modifier) {
        BackButtonScaffold(
            title = topBarTitle,
            hasBackStackElements = backstack.canHandeBackPress().collectAsState(),
            onBackPressed = { backstack.pop() }
        ) {
            AppyxComponent(
                appyxComponent = backstack,
                modifier = modifier
            )
        }
    }

    override fun resolve(interactionTarget: PlayerNav, buildContext: BuildContext): Node =
        when (interactionTarget) {
            is PlayerNav.PlayerList -> PlayersListNode(buildContext, allPlayers) {
                backstack.push(PlayerNav.PlayerDetail(it))
            }

            is PlayerNav.PlayerDetail -> {
                topBarTitle.value = "Player Detail"
                PlayerDetailNode(buildContext, interactionTarget.player)
            }
        }



}
