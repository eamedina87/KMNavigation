package navigation

import Team
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node

class TeamsNode(context: BuildContext) : Node(context) {

    @Composable
    override fun View(modifier: Modifier) {
        val allTeams = Team::class.
        
        TeamListScreen()
    }

}
