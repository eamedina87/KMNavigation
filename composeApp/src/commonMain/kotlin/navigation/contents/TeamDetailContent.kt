package navigation.contents

import Player
import Team
import TeamDetailScreen
import androidx.compose.runtime.Composable
import navigation.components.TeamDetailComponent

@Composable
fun TeamDetailContent(component: TeamDetailComponent, team: Team, topPlayers: List<Player>) {
    TeamDetailScreen(team, topPlayers)
}