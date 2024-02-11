package navigation.components

import Player
import allPlayers
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface PlayerDetailComponent {
    val player: Value<Player>
}

class PlayerDetailComponentImpl(
    context: ComponentContext,
    playerId: String
) : PlayerDetailComponent, ComponentContext by context {

    private val _player : MutableValue<Player> = MutableValue(allPlayers.find { it.name == playerId } ?: allPlayers.random())

    override val player: Value<Player> = _player


} 


