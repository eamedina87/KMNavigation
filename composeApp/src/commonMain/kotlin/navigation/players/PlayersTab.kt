package navigation.players

import Player
import PlayerListScreen
import allPlayers
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
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

    
    
    //#idea 1: create all nested navigations screens as tabs and replace with navigator push
    //idea 2: 
    
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        //{ player -> navigator.push(PlayerDetailTabScreen(player)) }
        Navigator(
            screen = PlayerListTabScreen(allPlayers) { player -> navigator.push(PlayerDetailTabScreen(player)) }
        ) {
            CurrentScreen()
        }
        
    }
    
}