package skullking.back.domain

import java.time.LocalDateTime
import java.util.*

class Game(
    val users: List<String>,
    val name: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val id: String =  UUID.randomUUID().toString()
    )
