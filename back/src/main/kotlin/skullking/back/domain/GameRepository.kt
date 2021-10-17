package skullking.back.domain

interface GameRepository {
    fun getAll(): List<Game>
    fun findById(id: String): Game
    fun save(game: Game)
}
