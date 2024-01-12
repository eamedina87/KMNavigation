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


@Composable
fun TeamDetailScreen(team: Team, topPlayers: List<Player>, modifier: Modifier = Modifier) {
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
            onPlayerSelected = { }
        )
    }
}