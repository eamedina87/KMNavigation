package navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
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
        val listComponent = TeamListComponentImpl(context = componentContext, onTeamSelected = { navigation.push(Config.Detail(it.name)) })

        return when (config) {
            is Config.List -> TeamsComponent.TeamsChild.List(listComponent)
            is Config.Detail -> {
                val detailComponent = TeamDetailComponentImpl(context = componentContext, config.id)
                TeamsComponent.TeamsChild.Detail(detailComponent)
            }
        }
    }
    
    @Serializable
    private sealed interface Config {

        @Serializable
        data object List : Config

        @Serializable
        data class Detail(val id: String) : Config
    }

}