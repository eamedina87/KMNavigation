package navigation

import com.arkivanov.decompose.ComponentContext


interface PlayersComponent {
    
}
class PlayersComponentImpl(
    componentContext: ComponentContext
) : PlayersComponent, ComponentContext by componentContext {
    
    
    
}