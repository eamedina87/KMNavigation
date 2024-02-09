package tech.medina.kmnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import navigation.MainContent
import navigation.RootComponentImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = RootComponentImpl(componentContext = defaultComponentContext())

        setContent {
            MainContent(rootComponent = root, modifier = Modifier.fillMaxSize())
        }
    }
}
