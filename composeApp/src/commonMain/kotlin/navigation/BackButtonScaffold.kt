package navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
@Composable
fun BackButtonScaffold(
    title: State<String>,
    hasBackStackElements: State<Boolean>,
    onBackPressed: () -> Unit,
    screenContent: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (hasBackStackElements.value) {
                TopAppBar(
                    title = { Text(text = title.value ) },
                    navigationIcon = {
                        IconButton(onClick = onBackPressed) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            } else {
                TopAppBar(
                    title = { Text(text = title.value) }
                )
            }
                 },
        ) {
        screenContent()
    }
}