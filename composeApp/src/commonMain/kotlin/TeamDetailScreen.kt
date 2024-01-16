import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.BackButtonScaffold


class TeamDetailTabScreen(private val team: Team) : Screen {

    @Composable
    override fun Content() {
        val topPlayers = allPlayers.filter { it.team == team.name }
        val navigator = LocalNavigator.currentOrThrow
        val onPlayerSelected: (Player) -> Unit = { player ->
            navigator.push(PlayerDetailTabScreen(player))
        }
        BackButtonScaffold("Team Detail") {
            TeamDetailScreen(team, topPlayers, onPlayerSelected)
        }
    }

}

@Composable
fun TeamDetailScreen(
    team: Team,
    topPlayers: List<Player>,
    onPlayerSelected: (Player) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Text(
            text = team.name,
            fontSize = 22.sp,
            modifier = modifier.
                align(Alignment.CenterHorizontally).
                padding(top = 24.dp)
        )
        Text(
            text = team.country,
            textAlign = TextAlign.Left,
            fontSize = 18.sp,
            modifier = modifier.padding(top = 8.dp)
        )
        Text(
            text = "Value: $${team.valueInMillions} Million",
            textAlign = TextAlign.Left,
            fontSize = 18.sp,
            modifier = modifier.padding(top = 8.dp)
        )
        PlayerListScreen(
            list = topPlayers,
            onPlayerSelected = onPlayerSelected
        )
    }
}