package navigation.contents

import Player
import Team
import TeamDetailScreen
import TeamListScreen
import allPlayers
import allTeams
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import navigation.components.TeamDetailComponent
import navigation.components.TeamsComponent
import navigation.components.TeamListComponent

@Composable
fun TeamsContent(component: TeamsComponent, modifier: Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is TeamsComponent.TeamsChild.List -> TeamListContent(child.component, allTeams, { team ->  child.component.onTeamClicked(team) })
            is TeamsComponent.TeamsChild.Detail -> TeamDetailContent(child.component, child.component.team.value , allPlayers)
        }
    }
}

@Composable
fun TeamListContent(component: TeamListComponent, list: List<Team>, onTeamSelected: (Team) -> Unit, modifier: Modifier = Modifier) {
    TeamListScreen(list, onTeamSelected, modifier)
}

@Composable
fun TeamDetailContent(component: TeamDetailComponent, team: Team, topPlayers: List<Player>) {
    TeamDetailScreen(team, topPlayers)
}