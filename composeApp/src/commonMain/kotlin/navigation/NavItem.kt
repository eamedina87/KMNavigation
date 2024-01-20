package navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.Modifier
import com.bumble.appyx.utils.material3.AppyxNavItem
import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

@Parcelize
enum class NavItem : Parcelable {
    TEAMS, PLAYERS;
    
    
    companion object {
        
        val resolver: (NavItem) -> AppyxNavItem = { navBarItem ->
            when (navBarItem) {
                TEAMS -> AppyxNavItem(
                    text = "Teams",
                    unselectedIcon = Icons.Outlined.Home,
                    selectedIcon = Icons.Filled.Home,
                    iconModifier = Modifier,
                    node = { TeamsNode(it) }
                )
                
                PLAYERS -> AppyxNavItem(
                    text = "Players",
                    unselectedIcon = Icons.Outlined.Person,
                    selectedIcon = Icons.Filled.Person,
                    iconModifier = Modifier,
                    node = { PlayersNode(it) }
                )
            }
            
        }
        
        
    }
    
}