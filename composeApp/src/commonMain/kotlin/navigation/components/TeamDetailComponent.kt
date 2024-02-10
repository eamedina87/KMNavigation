package navigation.components

import com.arkivanov.decompose.ComponentContext

interface TeamDetailComponent {

}

class TeamDetailComponentImpl(
    context: ComponentContext
) : TeamDetailComponent, ComponentContext by context {


} 


