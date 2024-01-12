package tech.medina.kmnavigation

import App
import PlayerDetailScreen
import Team
import TeamListScreen
import TeamDetailScreen
import PlayerListScreen
import allPlayers
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val allTeams = Team::class.sealedSubclasses.mapNotNull { it.objectInstance  }
        setContent {
            //TeamListScreen(allTeams)
            TeamDetailScreen(allTeams.random())
            //PlayerDetailScreen(allPlayers.random())
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}