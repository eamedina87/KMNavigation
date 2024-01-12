package navigation.players

import Player
import PlayerListScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

class PlayerListTabScreen(
    private val list: List<Player>,
    private val onPlayerSelected: (Player) -> Unit
) : Tab {
    
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
        PlayerListScreen(list, onPlayerSelected)
    }

}