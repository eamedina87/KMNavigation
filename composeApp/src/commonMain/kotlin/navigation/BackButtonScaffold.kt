package navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator

@Composable
fun BackButtonScaffold(title: String = "", screenContent: @Composable () -> Unit) {
    val tabNavigator = LocalTabNavigator.current
    Scaffold(
        topBar = {
            val topBarTitle = if (title.isBlank()) tabNavigator.current.options.title else title
            val navigator = LocalNavigator.currentOrThrow
            if (navigator.canPop) {
                TopAppBar(
                    title = { Text(text = topBarTitle ) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            } else {
                TopAppBar(
                    title = { Text(text = topBarTitle) }
                )
            }
         },
    ) {
        screenContent()
    }
}