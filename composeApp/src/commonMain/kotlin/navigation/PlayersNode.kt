package navigation

import PlayerListScreen
import allPlayers
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node

class PlayersNode(context: BuildContext) : Node(context) {

    @Composable
    override fun View(modifier: Modifier) {
        PlayerListScreen(allPlayers, {  })
    }
    
}
