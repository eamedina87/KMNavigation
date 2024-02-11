package navigation.components

import Team
import allTeams
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface TeamDetailComponent {
    val team: Value<Team>
}

class TeamDetailComponentImpl(
    context: ComponentContext,
    teamId: String
) : TeamDetailComponent, ComponentContext by context {

    private val _team : MutableValue<Team> = MutableValue(allTeams.find { it.name == teamId } ?: allTeams.random())

    override val team: Value<Team> = _team

} 


