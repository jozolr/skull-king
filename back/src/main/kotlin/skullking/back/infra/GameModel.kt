package skullking.back.infra

import org.springframework.data.redis.core.RedisHash
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
