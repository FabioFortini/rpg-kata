import java.lang.Integer.min

class Character {
    var health: Int = MAX_HEALTH
        private set
    var alive: Boolean = true
        private set
    val level: Int = 1

    fun heal(target: Character, health: Int) {
        if (target.isDead())
            return
        target.health = min(target.health + health, MAX_HEALTH)
    }

    private fun isDead() = !alive

    private fun killed() {
        health = 0
        alive = false
    }

    fun dealDamage(character: Character, health: Int) {
        if (this != character) {
            character.health -= health
            if (character.health <= 0)
                character.killed()
        }
    }

    companion object {
        private const val MAX_HEALTH: Int = 1000
    }
}
