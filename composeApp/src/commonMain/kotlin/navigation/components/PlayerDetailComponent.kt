package navigation.components

import com.arkivanov.decompose.ComponentContext

interface PlayerDetailComponent {

}

class PlayerDetailComponentImpl(
    context: ComponentContext
) : PlayerDetailComponent, ComponentContext by context {


} 


