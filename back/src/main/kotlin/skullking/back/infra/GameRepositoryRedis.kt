package skullking.back.infra

import org.springframework.stereotype.Service
import skullking.back.domain.Game
import skullking.back.domain.GameRepository

@Service
class GameRepositoryRedis(val gameModelRedis: GameModelRedis) : GameRepository {
    override fun getAll(): List<Game> {
        val gamesRedis = gameModelRedis.findAll()
        return gamesRedis.map(this::toGame)
    }

    override fun findById(id: String): Game {
        val optional = gameModelRedis.findById(id)
        if (optional.isPresent) {
            return toGame(optional.get())
        } else {
            throw Exception()
        }
    }

    override fun save(game: Game) {
        val gameModel = GameModel(game.users, game.name, game.creationDate, game.id)
        gameModelRedis.save(gameModel)
    }

    private fun toGame(gameModel: GameModel) = Game(gameModel.users, gameModel.name, gameModel.creationDate, gameModel.id)
}

