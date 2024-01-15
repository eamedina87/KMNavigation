package navigation.players

import PlayerListTabScreen
import allPlayers
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object PlayersTab : Tab {

    override val options: TabOptions
    @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Person)
            return remember {
                TabOptions(
                    index = 2u,
                    title = "Players",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(PlayerListTabScreen(allPlayers)) {
            CurrentScreen()
        }
    }
    
}