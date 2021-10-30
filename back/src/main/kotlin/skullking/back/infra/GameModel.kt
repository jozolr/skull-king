package skullking.back.infra

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.time.LocalDateTime

@RedisHash("Game")
class GameModel(
    val users: List<String>,
    val name: String,
    val creationDate: LocalDateTime,
    val id: String
    ) : Serializable {
}

@Repository
interface GameModelRedis : CrudRepository<GameModel, String>
