import kotlin.math.min

class RPGCharacter(val level: Int = 1) {
    var health: Int = MAX_HEALTH
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

    private fun calculateDamage(damage: Int, target: RPGCharacter): Int {
        if (target.level - this.level >= 5) {
            return damage / 2
        }
        if (this.level - target.level >= 5) {
            return (damage * 1.5).toInt()
        }
        return damage
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
