import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.BackButtonScaffold

class PlayerListTabScreen(private val list: List<Player>) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val onPlayerSelected: (Player) -> Unit = { navigator.push(PlayerDetailTabScreen(it)) }
        BackButtonScaffold {
            PlayerListScreen(list, onPlayerSelected)
        }
    }

}

@Composable
fun PlayerListScreen(
    list: List<Player>,
    onPlayerSelected: (Player) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(top = 24.dp, bottom = 16.dp)
    ) {
        Text("Featured Players")
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(list.sortedWith(compareBy<Player> { it.team }.thenByDescending { it.valueInMillions })) { player ->
                PlayerItem(player, onPlayerSelected)
            }
        }
    }
}

@Composable
private fun PlayerItem(player: Player, onItemClicked: (Player) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.
            fillMaxWidth().
            height(56.dp).
            clickable { onItemClicked(player) }
    ) {
        Text(
            text = player.name,
            fontSize = 18.sp,
            )
        Text(
            text = "#${player.number} - ${player.position}",
            fontSize = 14.sp,
            modifier = modifier.padding(start = 4.dp)
        )
    }
}