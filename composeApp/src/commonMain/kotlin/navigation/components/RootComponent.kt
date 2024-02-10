package navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable
import navigation.PlayersComponent
import navigation.PlayersComponentImpl

interface RootComponent {
    
    val childStack: Value<ChildStack<*, RootChild>>
    
    fun onTeamsTabClicked()
    fun onPlayersTabClicked()
    
    sealed class RootChild {
        data class Teams(val component: TeamsComponent) : RootChild()
        data class Players(val component: PlayersComponent) : RootChild()
    }
    
}

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    
    private val navigation = StackNavigation<Config>()
    override val childStack: Value<ChildStack<*, RootComponent.RootChild>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Teams,
            serializer = Config.serializer(),
            handleBackButton = true,
            childFactory = ::child
        )

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.RootChild =
        when (config) {
            is Config.Players -> RootComponent.RootChild.Players(PlayersComponentImpl(componentContext))
            is Config.Teams -> RootComponent.RootChild.Teams(TeamsComponentImpl(componentContext))
        }
    
    override fun onTeamsTabClicked() {
        navigation.bringToFront(Config.Teams)
    }

    override fun onPlayersTabClicked() {
        navigation.bringToFront(Config.Players)
    }
    
    @Serializable
    private sealed interface Config {
        
        @Serializable
        data object Teams : Config

        @Serializable
        data object Players : Config
    }

}