package navigation.components

import com.arkivanov.decompose.ComponentContext

interface PlayerListComponent {

}

class PlayerListComponentImpl(
    context: ComponentContext
) : PlayerListComponent, ComponentContext by context {


} 


