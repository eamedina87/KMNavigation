import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamListScreen(list: List<Team>, onTeamSelected: (Team) -> Unit, modifier: Modifier = Modifier) {
    Column {
        Text("All Teams")
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(list.sortedBy { it.name }) { team ->
                TeamItem(team, onTeamSelected)
            }
        }
    }
}

@Composable
private fun TeamItem(team: Team, onItemClick: (Team) -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier.
        fillMaxWidth().
        height(56.dp).
        clickable { onItemClick(team) }
    ) {
        Text(
            text = team.name,
            fontSize = 22.sp,
            )
    }
}