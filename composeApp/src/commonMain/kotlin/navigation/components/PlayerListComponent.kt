package navigation.components

import Player
import com.arkivanov.decompose.ComponentContext

interface PlayerListComponent {
    fun onPlayerClicked(player: Player)
}

class PlayerListComponentImpl(
    context: ComponentContext,
    private val onPlayerSelected: (Player) -> Unit
) : PlayerListComponent, ComponentContext by context {

    override fun onPlayerClicked(player: Player) {
        onPlayerSelected(player)
    }

} 


