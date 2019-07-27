package models

class PlayBook(private val plays: Iterable<Play>) {
    fun execute(dryRun: Boolean = true) {
        plays.forEach { it.execute(dryRun) }
    }
}