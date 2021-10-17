package skullking.back.api

import org.springframework.web.bind.annotation.*
import skullking.back.domain.Game
import skullking.back.domain.GameRepository
import skullking.back.domain.command.CreateGame

@RestController
class GameApi(val gameRepository: GameRepository, val createGame: CreateGame) {

    @GetMapping("/games")
    fun get(): List<Game> {
        return gameRepository.getAll()
    }

    @GetMapping("/games/{id}")
    fun getById(@PathVariable id: String): Game {
        return gameRepository.findById(id)
    }

    @PostMapping("/games")
    fun post(@RequestBody createGameResource: CreateGameResource): Game {
        return createGame.execute(createGameResource.users, createGameResource.name)
    }
}
