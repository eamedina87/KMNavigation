import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.*
import navigation.players.PlayersTab
import navigation.teams.TeamsTab

@Composable
fun TabNavigatorComponent(modifier: Modifier = Modifier) {
    TabNavigator(
        TeamsTab,
        tabDisposable = {
            TabDisposable(
                navigator = it,
                tabs = listOf(TeamsTab, PlayersTab)
            )
        }
    ) { tabNavigator ->
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = tabNavigator.current.options.title) })
            },
            content = {
                CurrentTab()
            },
            bottomBar = {
                BottomNavigation {
                    TabNavigationItem(TeamsTab)
                    TabNavigationItem(PlayersTab)
                }
            }
        )
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}