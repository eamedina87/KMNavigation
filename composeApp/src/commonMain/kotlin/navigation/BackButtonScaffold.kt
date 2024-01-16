package navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator

@Composable
fun BackButtonScaffold(screenContent: @Composable () -> Unit) {
    val tabNavigator = LocalTabNavigator.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = tabNavigator.current.options.title) },
                navigationIcon = {
                    val navigator = LocalNavigator.currentOrThrow
                    IconButton(onClick = { navigator.pop() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
         },
    ) {
        screenContent()
    }
}