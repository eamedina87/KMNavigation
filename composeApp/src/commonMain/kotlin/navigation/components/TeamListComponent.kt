package navigation.components

import com.arkivanov.decompose.ComponentContext

interface TeamListComponent {
    
}

class TeamListComponentImpl(
    context: ComponentContext
) : TeamListComponent, ComponentContext by context {
    
    
} 

