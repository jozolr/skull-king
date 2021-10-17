package skullking.back.infra

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import skullking.back.domain.Game
import skullking.back.domain.GameRepository

@Service
class GameRepositoryRedis(val gameRedisOrm: GameRedisOrm) : GameRepository {
    override fun getAll(): List<Game> {
        val gamesRedis = gameRedisOrm.findAll()
        return gamesRedis.map(this::toGame)
    }

    override fun findById(id: String): Game {
        val optional = gameRedisOrm.findById(id)
        if (optional.isPresent) {
            return toGame(optional.get())
        } else {
            throw Exception()
        }
    }

    override fun save(game: Game) {
        val gameModel = GameModel(game.users, game.name, game.creationDate, game.id)
        gameRedisOrm.save(gameModel)
    }

    private fun toGame(gameModel: GameModel) = Game(gameModel.users, gameModel.name, gameModel.creationDate, gameModel.id)
}

@Repository
interface GameRedisOrm : CrudRepository<GameModel, String>
