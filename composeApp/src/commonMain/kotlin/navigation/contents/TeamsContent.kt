package navigation.contents

import allPlayers
import allTeams
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.components.TeamListComponent
import navigation.components.TeamsComponent

@Composable
fun TeamsContent(component: TeamsComponent, modifier: Modifier) {
    val children = component.childStack.subscribeAsState()
    
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is TeamsComponent.TeamsChild.List -> TeamListContent(child.component, allTeams, { child.component.onTeamClicked(it) })
            is TeamsComponent.TeamsChild.Detail -> TeamDetailContent(child.component, child.component.team.value , allPlayers)
        }
    }
}
