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
import com.bumble.appyx.navigation.children.ChildAwareImpl
import com.bumble.appyx.navigation.composable.AppyxComponent
import com.bumble.appyx.navigation.lifecycle.DefaultPlatformLifecycleObserver
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.ParentNode
import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
class TeamsNode(
    context: BuildContext,
    private val backstack: BackStack<TeamNav> = BackStack(
        model = BackStackModel(
            initialTarget = TeamNav.TeamList,
            savedStateMap = context.savedStateMap
        ),
        visualisation = { BackStackFader(it) }

    )
) : ParentNode<TeamsNode.TeamNav>(
    buildContext = context,
    appyxComponent = backstack,
) {

    private val topBarTitle: MutableState<String> = mutableStateOf("Teams")

    sealed class TeamNav : Parcelable {
        @Parcelize data object TeamList : TeamNav()
        @Parcelize data class TeamDetail(val team: Team) : TeamNav()
        @Parcelize data class PlayerDetail(val player: Player) : TeamNav()

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

    override fun resolve(interactionTarget: TeamNav, buildContext: BuildContext): Node =
        when (interactionTarget) {
            is TeamNav.TeamList -> TeamListNode(buildContext, allTeams) { backstack.push(TeamNav.TeamDetail(it)) }
            is TeamNav.TeamDetail -> {
                backstack.onRelease()
                topBarTitle.value = "Team Detail"
                TeamDetailNode(
                    buildContext = buildContext,
                    team = interactionTarget.team,
                    topPlayers = allPlayers.filter { it.team == interactionTarget.team.name },
                    onPlayerSelected = { backstack.push(TeamNav.PlayerDetail(it)) }
                )
            }
            is TeamNav.PlayerDetail -> {
                topBarTitle.value = "Player Detail"
                PlayerDetailNode(buildContext, interactionTarget.player)
            }
        }


}
