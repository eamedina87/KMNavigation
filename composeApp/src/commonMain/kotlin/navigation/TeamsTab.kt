package navigation


import TeamListTabScreen
import allTeams
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object TeamsTab: Tab {
    
    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            return remember {
                TabOptions(
                    index = 1u,
                    title = "Teams",
                    icon = icon
                )
            }
        }
    
    @Composable
    override fun Content() {
        Navigator(TeamListTabScreen(allTeams)) {
            CurrentScreen()
        }
    }

}