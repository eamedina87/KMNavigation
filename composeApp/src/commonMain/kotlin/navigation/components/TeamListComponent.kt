package navigation.components

import Team
import com.arkivanov.decompose.ComponentContext

interface TeamListComponent {
    fun onTeamClicked(team: Team)
}

class TeamListComponentImpl(
    context: ComponentContext,
    private val onTeamSelected: (Team) -> Unit
) : TeamListComponent, ComponentContext by context {
    
    override fun onTeamClicked(team: Team) {
        onTeamSelected(team)
    }

} 

