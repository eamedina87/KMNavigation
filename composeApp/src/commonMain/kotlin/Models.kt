import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

@Parcelize data class Player(val name: String, val position: String, val number: Int, val team: String, val country: String, val valueInMillions: Int) : Parcelable

@Parcelize data class Team(val name: String, val image: String, val country: String, val valueInMillions: Int) : Parcelable

val allTeams = listOf(
    Team(name = "FC Barcelona", image = "compose-multiplatform.xml", country = "Spain", valueInMillions = 858),
    Team(name = "Real Madrid", image = "compose-multiplatform.xml", country = "Spain", valueInMillions = 1040),
    Team(name = "Atlético de Madrid", image = "compose-multiplatform.xml", country = "Spain", valueInMillions = 442),
    Team(name = "Juventus", image = "compose-multiplatform.xml", country = "Italy", valueInMillions = 424),
    Team(name = "Inter de Milan", image = "compose-multiplatform.xml", country = "Italy", valueInMillions = 589),
    Team(name = "AC Milan", image = "compose-multiplatform.xml", country = "Italy", valueInMillions = 541),
    Team(name = "Manchester United", image = "compose-multiplatform.xml", country = "England", valueInMillions = 751),
    Team(name = "Manchester City", image = "compose-multiplatform.xml", country = "England", valueInMillions = 1290),
    Team(name = "Liverpool", image = "compose-multiplatform.xml", country = "England", valueInMillions = 872),
    Team(name = "Arsenal", image = "compose-multiplatform.xml", country = "England", valueInMillions = 1110),
    Team(name = "Chelsea", image = "compose-multiplatform.xml", country = "England", valueInMillions = 986),
    Team(name = "Tottenham Hotspur", image = "compose-multiplatform.xml", country = "England", valueInMillions = 788)
)

val allPlayers = listOf(
    Player("Federico Valverde", "Midfielder", 15, "Real Madrid", "Uruguay", 100),
    Player("Jude Bellingham", "Midfielder", 5, "Real Madrid", "England", 180),
    Player("Vinicius Junior", "Attacker", 7, "Real Madrid", "Brazil", 100),
    Player("Frenkie de Jong", "Midfielder", 21, "FC Barcelona", "Netherlands", 80),
    Player("Gavi", "Midfielder", 6, "FC Barcelona", "Spain", 90),
    Player("Pedri", "Midfielder", 8, "FC Barcelona", "Spain", 90),
    Player("Nahuel Molina", "Defender", 16, "Atlético de Madrid", "Argentina", 45),
    Player("Jan Oblak", "Goalkeeper", 13, "Atlético de Madrid", "Slovenia", 35),
    Player("Jose María Giménez", "Defender", 2, "Atlético de Madrid", "Uruguay", 30),
    Player("Dusan Vlahovic", "Attacker", 9, "Juventus", "Serbia", 60),
    Player("Federico Chiesa", "Attacker", 7, "Juventus", "Italy", 50),
    Player("Bremer", "Defender", 3, "Juventus", "Brazil", 50),
    Player("Lautaro Martínez", "Attacker", 10, "Inter de Milan", "Argentina", 110),
    Player("Nicolo Barella", "Midfielder", 23, "Inter de Milan", "Italy", 75),
    Player("Alessandro Bastoni", "Defender", 95, "Inter de Milan", "Italy", 60),
    Player("Rafael Leao", "Attacker", 10, "AC Milan", "Portugal", 90),
    Player("Theo Hernández", "Defender", 19, "AC Milan", "France", 55),
    Player("Mike Maignan", "Goalkeeper", 16, "AC Milan", "France", 45),
    Player("Bruno Fernandez", "Midfielder", 8, "Manchester United", "Portugal", 70),
    Player("Marcus Rashford", "Attacker", 10, "Manchester United", "England", 70),
    Player("Rasmus Hojlund", "Attacker", 11, "Manchester United", "Denmark", 65),
    Player("Erling Haaland", "Attacker", 9, "Manchester City", "Norway", 180),
    Player("Rodri", "Midfielder", 16, "Manchester City", "Spain", 110),
    Player("Phil Foden", "Attacker", 47, "Manchester City", "England", 110),
    Player("Dominik Skoboszlai", "Midfielder", 8, "Liverpool", "Hungary", 75),
    Player("Luis Diaz", "Attacker", 8, "Liverpool", "Colombia", 75),
    Player("Trent Alexander-Arnold", "Defender", 66, "Liverpool", "England", 70),
    Player("Bukayo Saka", "Attacker", 7, "Arsenal", "England", 120),
    Player("Declan Rice", "Midfielder", 41, "Arsenal", "England", 110),
    Player("Martin Odegaard", "Midfielder", 8, "Arsenal", "Norway", 90),
    Player("Moisés Caicedo", "Midfielder", 25, "Chelsea", "Ecuador", 90),
    Player("Enzo Fernández", "Midfielder", 8, "Chelsea", "Argentina", 80),
    Player("Christopher Nkunku", "Midfielder", 18, "Chelsea", "France", 75),
    Player("James Madison", "Midfielder", 10, "Tottenham Hotspur", "England", 70),
    Player("Cristian Romero", "Defender", 17, "Tottenham Hotspur", "Argentina", 65),
    Player("Dejan Kulusevski", "Attacker", 21, "Tottenham Hotspur", "Sweden", 55),
)