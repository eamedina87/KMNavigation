
sealed class Team(val name: String, val image: String, val country: String, val valueInMillions: Int) {
    data object Barcelona : Team(name = "FC Barcelona", image = "compose-multiplatform.xml", country = "Spain", valueInMillions = 858)
    data object RealMadrid : Team(name = "Real Madrid", image = "compose-multiplatform.xml", country = "Spain", valueInMillions = 1040)
    data object AtleticoMadrid : Team(name = "Atlético de Madrid", image = "compose-multiplatform.xml", country = "Spain", valueInMillions = 442)
    data object Juventus : Team(name = "Juventus", image = "compose-multiplatform.xml", country = "Italy", valueInMillions = 424)
    data object InterMilan : Team(name = "Inter de Milan", image = "compose-multiplatform.xml", country = "Italy", valueInMillions = 589)
    data object AcMilan: Team(name = "AC Milan", image = "compose-multiplatform.xml", country = "Italy", valueInMillions = 541)
    data object ManchesterUnited : Team(name = "Manchester United", image = "compose-multiplatform.xml", country = "England", valueInMillions = 751)
    data object ManchesterCity : Team(name = "Manchester City", image = "compose-multiplatform.xml", country = "England", valueInMillions = 1290)
    data object Liverpool : Team(name = "Liverpool", image = "compose-multiplatform.xml", country = "England", valueInMillions = 872)
    data object Arsenal : Team(name = "Arsenal", image = "compose-multiplatform.xml", country = "England", valueInMillions = 1110)
    data object Chelsea : Team(name = "Chelsea", image = "compose-multiplatform.xml", country = "England", valueInMillions = 986)
    data object Tottenham : Team(name = "Tottenham Hotspur", image = "compose-multiplatform.xml", country = "England", valueInMillions = 788)
}

enum class Position {
    Goalkeeper, Defender, Midfielder, Attacker
}

data class Player(val name: String, val position: Position, val number: Int, val team: Team, val country: String, val valueInMillions: Int)

val allPlayers = listOf(
    Player("Federico Valverde", Position.Midfielder, 15, Team.RealMadrid, "Uruguay", 100),
    Player("Jude Bellingham", Position.Midfielder, 5, Team.RealMadrid, "England", 180),
    Player("Vinicius Junior", Position.Attacker, 7, Team.RealMadrid, "Brazil", 100),
    Player("Frenkie de Jong", Position.Midfielder, 21, Team.Barcelona, "Netherlands", 80),
    Player("Gavi", Position.Midfielder, 6, Team.Barcelona, "Spain", 90),
    Player("Pedri", Position.Midfielder, 8, Team.Barcelona, "Spain", 90),
    Player("Nahuel Molina", Position.Defender, 16, Team.AtleticoMadrid, "Argentina", 45),
    Player("Jan Oblak", Position.Goalkeeper, 13, Team.AtleticoMadrid, "Slovenia", 35),
    Player("Jose María Giménez", Position.Defender, 2, Team.AtleticoMadrid, "Uruguay", 30),
    Player("Dusan Vlahovic", Position.Attacker, 9, Team.Juventus, "Serbia", 60),
    Player("Federico Chiesa", Position.Attacker, 7, Team.Juventus, "Italy", 50),
    Player("Bremer", Position.Defender, 3, Team.Juventus, "Brazil", 50),
    Player("Lautaro Martínez", Position.Attacker, 10, Team.InterMilan, "Argentina", 110),
    Player("Nicolo Barella", Position.Midfielder, 23, Team.InterMilan, "Italy", 75),
    Player("Alessandro Bastoni", Position.Defender, 95, Team.InterMilan, "Italy", 60),
    Player("Rafael Leao", Position.Attacker, 10, Team.AcMilan, "Portugal", 90),
    Player("Theo Hernández", Position.Defender, 19, Team.AcMilan, "France", 55),
    Player("Mike Maignan", Position.Goalkeeper, 16, Team.AcMilan, "France", 45),
    Player("Bruno Fernandez", Position.Midfielder, 8, Team.ManchesterUnited, "Portugal", 70),
    Player("Marcus Rashford", Position.Attacker, 10, Team.ManchesterUnited, "England", 70),
    Player("Rasmus Hojlund", Position.Attacker, 11, Team.ManchesterUnited, "Denmark", 65),
    Player("Erling Haaland", Position.Attacker, 9, Team.ManchesterCity, "Norway", 180),
    Player("Rodri", Position.Midfielder, 16, Team.ManchesterCity, "Spain", 110),
    Player("Phil Foden", Position.Attacker, 47, Team.ManchesterCity, "England", 110),
    Player("Dominik Skoboszlai", Position.Midfielder, 8, Team.Liverpool, "Hungary", 75),
    Player("Luis Diaz", Position.Attacker, 8, Team.Liverpool, "Colombia", 75),
    Player("Trent Alexander-Arnold", Position.Defender, 66, Team.Liverpool, "England", 70),
    Player("Bukayo Saka", Position.Attacker, 7, Team.Arsenal, "England", 120),
    Player("Declan Rice", Position.Midfielder, 41, Team.Arsenal, "England", 110),
    Player("Martin Odegaard", Position.Midfielder, 8, Team.Arsenal, "Norway", 90),
    Player("Moisés Caicedo", Position.Midfielder, 25, Team.Chelsea, "Ecuador", 90),
    Player("Enzo Fernández", Position.Midfielder, 8, Team.Chelsea, "Argentina", 80),
    Player("Christopher Nkunku", Position.Midfielder, 18, Team.Chelsea, "France", 75),
    Player("James Madison", Position.Midfielder, 10, Team.Tottenham, "England", 70),
    Player("Cristian Romero", Position.Defender, 17, Team.Tottenham, "Argentina", 65),
    Player("Dejan Kulusevski", Position.Attacker, 21, Team.Tottenham, "Sweden", 55),
)