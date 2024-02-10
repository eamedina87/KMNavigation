package navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

interface TeamsComponent {
    val childStack: Value<ChildStack<*, TeamsChild>>
    
    sealed class TeamsChild {
        data class List(val component: TeamListComponent) : TeamsChild()
        data class Detail(val component: TeamDetailComponent) : TeamsChild()
    }
}

class TeamsComponentImpl(
    componentContext: ComponentContext
) : TeamsComponent, ComponentContext by componentContext {
    
    private val navigation = StackNavigation<Config>()
    
    override val childStack: Value<ChildStack<*, TeamsComponent.TeamsChild>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.List,
            serializer = Config.serializer(),
            handleBackButton = true,
            childFactory = ::child
        )
    
    private fun child(config: Config, componentContext: ComponentContext): TeamsComponent.TeamsChild {
        val listComponent = TeamListComponentImpl(context = componentContext)
        val detailComponent = TeamDetailComponentImpl(context = componentContext)
        return when (config) {
            is Config.List -> TeamsComponent.TeamsChild.List(listComponent)
            is Config.Detail -> TeamsComponent.TeamsChild.Detail(detailComponent)
            else -> throw NoSuchElementException("TeamsComponent child not expected")
        }
    }
    
    @Serializable
    private sealed interface Config {

        @Serializable
        data object List : Config

        @Serializable
        data object Detail : Config
    }

}