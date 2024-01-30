package navigation

import Player
import PlayerDetailNode
import Team
import TeamDetailNode
import TeamListNode
import allPlayers
import allTeams
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.operation.pop
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.interactions.core.ui.helper.AppyxComponentSetup
import com.bumble.appyx.navigation.composable.AppyxNavigationContainer
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

class TeamsNode(
    context: NodeContext,
    private val backstack: BackStack<TeamNav> = BackStack(
        model = BackStackModel(
            initialTarget = TeamNav.TeamList,
            savedStateMap = context.savedStateMap
        ),
        visualisation = { BackStackFader(it) }

    )
) : Node<TeamsNode.TeamNav>(
    nodeContext = context,
    appyxComponent = backstack,
) {

    private val topBarTitle: MutableState<String> = mutableStateOf("Teams")

    sealed class TeamNav : Parcelable {
        @Parcelize data object TeamList : TeamNav()
        @Parcelize data class TeamDetail(val team: Team) : TeamNav()
        @Parcelize data class PlayerDetail(val player: Player) : TeamNav()

    }

    
    @Composable
    override fun Content(modifier: Modifier) {
        BackButtonScaffold(
            title = topBarTitle,
            hasBackStackElements = backstack.canHandeBackPress().collectAsState(),
            onBackPressed = { backstack.pop() }
        ) {
            AppyxNavigationContainer(
                appyxComponent = backstack,
                modifier = modifier
            )
        }
    }

    override fun buildChildNode(navTarget: TeamNav, nodeContext: NodeContext): Node<*> =
        when (navTarget) {
            is TeamNav.TeamList -> TeamListNode(nodeContext, allTeams) { backstack.push(TeamNav.TeamDetail(it)) }
            is TeamNav.TeamDetail -> {
                backstack.onRelease()
                topBarTitle.value = "Team Detail"
                TeamDetailNode(
                    context = nodeContext,
                    team = navTarget.team,
                    topPlayers = allPlayers.filter { it.team == navTarget.team.name },
                    onPlayerSelected = { backstack.push(TeamNav.PlayerDetail(it)) }
                )
            }
            is TeamNav.PlayerDetail -> {
                topBarTitle.value = "Player Detail"
                PlayerDetailNode(nodeContext, navTarget.player)
            }
        }


}
