import kotlin.math.min

class RPGCharacter(val level: Int = 1) {
    val maxRange: Int = 2
    var health: Float = MAX_HEALTH
        private set
    var alive: Boolean = true
        private set

    fun heal(amount: Int) {
        if (isDead())
            return

        health = min(health + amount, MAX_HEALTH)
    }

    fun dealDamage(target: RPGCharacter, damage: Int) {
        if (this == target) {
            return
        }

        target.health -= calculateDamage(damage, target)
        if (target.health <= 0)
            target.killed()
    }

    private fun calculateDamage(damage: Int, target: RPGCharacter): Float {
        if (target.level - this.level >= 5) {
            return damage / 2F
        }
        if (this.level - target.level >= 5) {
            return damage * 1.5F
        }
        return damage.toFloat()
    }

    private fun isDead() = !alive

    private fun killed() {
        health = 0F
        alive = false
    }

    companion object {
        private const val MAX_HEALTH: Float = 1000F
    }
}
