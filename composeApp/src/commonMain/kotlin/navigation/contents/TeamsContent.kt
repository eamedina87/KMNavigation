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
import navigation.components.TeamsComponent

@Composable
fun TeamsContent(component: TeamsComponent, modifier: Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is TeamsComponent.TeamsChild.List -> TeamListScreen(allTeams, { team ->  child.component.onTeamClicked(team) })
            is TeamsComponent.TeamsChild.Detail -> TeamDetailScreen(child.component.team.value , allPlayers)
        }
    }
}