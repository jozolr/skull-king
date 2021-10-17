package skullking.back.domain.command

import org.springframework.stereotype.Service
import skullking.back.domain.Game
import skullking.back.domain.GameRepository

@Service
class CreateGame(val gameRepository: GameRepository) {
    fun execute(users: List<String>, name: String): Game {
        val game = Game(users, name)
        gameRepository.save(game)
        return game
    }
}
