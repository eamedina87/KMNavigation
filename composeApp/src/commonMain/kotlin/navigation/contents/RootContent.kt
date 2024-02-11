package navigation.contents

import PlayerListScreen
import TeamListScreen
import allPlayers
import allTeams
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.components.RootComponent

@Composable
fun MainContent(rootComponent: RootComponent, modifier: Modifier = Modifier) {
    Column {
        RootContent(
            component = rootComponent,
            modifier = modifier.weight(1f)
        )
        BottomNavigationBar(
            rootComponent
        )
    }
}

@Composable
private fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is RootComponent.RootChild.Teams -> TeamsContent(child.component, modifier)
            is RootComponent.RootChild.Players -> PlayersContent(child.component, modifier)
        }
    }
}

@Composable
private fun BottomNavigationBar(component: RootComponent, modifier: Modifier = Modifier) {
    
    val childStack =  component.childStack.subscribeAsState()
    val activeComponent = childStack.value.active.instance
    
    BottomNavigation(modifier = modifier) {
        BottomNavigationItem(
            selected = activeComponent is RootComponent.RootChild.Teams,
            onClick = component::onTeamsTabClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Teams"
                )
            }
        )
        BottomNavigationItem(
            selected = activeComponent is RootComponent.RootChild.Teams,
            onClick = component::onPlayersTabClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Players"
                )
            }
        )
        
    }
}