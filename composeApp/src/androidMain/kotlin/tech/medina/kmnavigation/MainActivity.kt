package tech.medina.kmnavigation

import PlayerListScreen
import Team
import TeamListScreen
import allPlayers
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import navigation.App
import navigation.BottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val allTeams = Team::class.sealedSubclasses.mapNotNull { it.objectInstance  }

        setContent {
            Scaffold(bottomBar = { BottomBar() }) {
                App()
                //PlayerListScreen(allPlayers, { Toast.makeText(this, "Player Selected: $it", Toast.LENGTH_SHORT).show() })
            }

            /*TeamListScreen(allTeams, { Toast.makeText(this, "Team Selected: $it", Toast.LENGTH_SHORT).show() })
            val team = allTeams.random()*/
            //TeamDetailScreen(team, allPlayers.filter { it.team == team })//{ Toast.makeText(this, "Team Selected: $it", Toast.LENGTH_SHORT).show() })
            //PlayerDetailScreen(allPlayers.random())
            //PlayerListScreen(allPlayers, { Toast.makeText(this, "Player Selected: $it", Toast.LENGTH_SHORT).show() })
        }
    }

}
