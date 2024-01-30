import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.bumble.appyx.navigation.integration.IosNodeHost
import com.bumble.appyx.navigation.integration.MainIntegrationPoint
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import navigation.RootNode
import navigation.TeamsNode

val backEvents: Channel<Unit> = Channel()

val integrationPoint = MainIntegrationPoint()

fun MainViewController() = ComposeUIViewController {
    MaterialTheme {
        IosNodeHost(
            modifier = Modifier,
            onBackPressedEvents = backEvents.receiveAsFlow(),
            integrationPoint = integrationPoint,
            factory = { RootNode(context = it) }
                )
            }
}.also {
    integrationPoint.setViewController(it)
}

