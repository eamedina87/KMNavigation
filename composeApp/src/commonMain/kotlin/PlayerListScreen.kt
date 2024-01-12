import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayerListScreen(list: List<Player>, modifier: Modifier = Modifier) {
    Column {
        Text("Featured Players")
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(list.sortedWith(compareBy<Player> { it.team.name }.thenByDescending { it.valueInMillions })) { player ->
                PlayerItem(player)
            }
        }
    }
}

@Composable
private fun PlayerItem(player: Player, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().height(56.dp)) {
        Text(
            text = player.name,
            fontSize = 18.sp,
            )
        Text(
            text = "#${player.number} - ${player.position.name}",
            fontSize = 14.sp,
            modifier = modifier.padding(start = 4.dp)
        )
    }
}