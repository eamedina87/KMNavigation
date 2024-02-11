import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.lifecycle.ApplicationLifecycle
import navigation.components.RootComponentImpl
import navigation.contents.MainContent

@OptIn(ExperimentalDecomposeApi::class)
fun MainViewController() = ComposeUIViewController {
    val context = DefaultComponentContext(ApplicationLifecycle())
    val root = RootComponentImpl(componentContext = context)

    MainContent(rootComponent = root)
}
