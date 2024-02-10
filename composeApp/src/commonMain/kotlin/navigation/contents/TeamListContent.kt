package navigation.contents

import Team
import TeamListScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import navigation.components.TeamsComponent

@Composable
fun TeamListContent(component: TeamsComponent, list: List<Team>, onTeamSelected: (Team) -> Unit, modifier: Modifier = Modifier) {
    TeamListScreen(list, onTeamSelected, modifier)
}