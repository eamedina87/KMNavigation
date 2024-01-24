import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
class TeamListNode(
    buildContext: BuildContext,
    private val teams: List<Team>,
    private val onTeamSelected: (Team) -> Unit
) : Node(buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        TeamListScreen(teams, onTeamSelected)
    }

}

//@OptIn(ExperimentalObjCRefinement::class)
//@HiddenFromObjC
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

//@OptIn(ExperimentalObjCRefinement::class)
//@HiddenFromObjC
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