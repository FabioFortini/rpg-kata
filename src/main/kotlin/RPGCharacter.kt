import java.lang.Integer.min

class RPGCharacter {
    var health: Int = MAX_HEALTH
        private set
    var alive: Boolean = true
        private set
    val level: Int = 1

    fun heal(target: RPGCharacter, health: Int) {
        if (target.isDead())
            return
        target.health = min(target.health + health, MAX_HEALTH)
    }

    fun dealDamage(target: RPGCharacter, health: Int) {
        if (this == target) {
            return
        }

        target.health -= health
        if (target.health <= 0)
            target.killed()
    }

    private fun isDead() = !alive

    private fun killed() {
        health = 0
        alive = false
    }

    companion object {
        private const val MAX_HEALTH: Int = 1000
    }
}
