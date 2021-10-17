package skullking.back

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SkullkingApplication

fun main(args: Array<String>) {
	runApplication<SkullkingApplication>(*args)
}
