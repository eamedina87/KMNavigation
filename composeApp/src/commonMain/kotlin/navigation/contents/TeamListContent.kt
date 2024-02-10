package navigation.contents

import Team
import TeamListScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import navigation.components.TeamListComponent

@Composable
fun TeamListContent(component: TeamListComponent, list: List<Team>, onTeamSelected: (Team) -> Unit, modifier: Modifier = Modifier) {
    TeamListScreen(list, onTeamSelected, modifier)
}