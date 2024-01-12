package tech.medina.kmnavigation

import TabNavigatorComponent
import Team
import TeamListScreen
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val allTeams = Team::class.sealedSubclasses.mapNotNull { it.objectInstance  }

        setContent {
            //TeamListScreen(allTeams, { Toast.makeText(this, "Team Selected: $it", Toast.LENGTH_SHORT).show() })
            val team = allTeams.random()
            //TeamDetailScreen(team, allPlayers.filter { it.team == team })//{ Toast.makeText(this, "Team Selected: $it", Toast.LENGTH_SHORT).show() })
            //PlayerDetailScreen(allPlayers.random())
            //PlayerListScreen(allPlayers, { Toast.makeText(this, "Player Selected: $it", Toast.LENGTH_SHORT).show() })
            TabNavigatorComponent()
        }
    }
}
