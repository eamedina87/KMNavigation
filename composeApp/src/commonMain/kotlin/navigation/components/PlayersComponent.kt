package navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

interface PlayersComponent {
    val childStack: Value<ChildStack<*, PlayersChild>>

    sealed class PlayersChild {
        data class List(val component: PlayerListComponent) : PlayersChild()
        data class Detail(val component: PlayerDetailComponent) : PlayersChild()
    }
}
class PlayersComponentImpl(
    componentContext: ComponentContext
) : PlayersComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, PlayersComponent.PlayersChild>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.List,
            serializer = Config.serializer(),
            handleBackButton = true,
            childFactory = ::child
        )

    private fun child(config: Config, componentContext: ComponentContext): PlayersComponent.PlayersChild {
        val listComponent = PlayerListComponentImpl(context = componentContext, onPlayerSelected = { navigation.push(
            Config.Detail(it.name)
        ) })

        return when (config) {
            is Config.List -> PlayersComponent.PlayersChild.List(listComponent)
            is Config.Detail -> {
                val detailComponent = PlayerDetailComponentImpl(context = componentContext, config.id)
                PlayersComponent.PlayersChild.Detail(detailComponent)
            }
            else -> PlayersComponent.PlayersChild.List(listComponent)
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