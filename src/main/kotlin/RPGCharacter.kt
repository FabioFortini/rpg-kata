import kotlin.math.abs
import kotlin.math.min

open class RPGCharacter(val level: Int = 1, val maxRange: Int = 2, val position: Int = 0) {
    private val factions: MutableList<String> = mutableListOf()
    var health: Float = MAX_HEALTH
        private set
    var alive: Boolean = true
        private set

    fun heal(amount: Int) {
        if (isDead()) return

        health = min(health + amount, MAX_HEALTH)
    }

    fun dealDamage(target: RPGCharacter, damage: Int) {
        if (this == target) {
            return
        }

        if (isNotInRange(target)){
            return
        }

        target.health -= calculateDamage(damage, target)
        if (target.health <= 0) target.killed()
    }

    private fun isNotInRange(target: RPGCharacter) = abs(this.position - target.position) > this.maxRange

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

    fun joinFaction(faction: String) {
        factions.add(faction)
    }

    fun factions(): List<String> {
        return factions.toList()
    }

    fun leaveFaction(faction: String) {
        factions.remove(faction)
    }

    fun areAlliedTo(characterB: RPGCharacter): Boolean {
        return factions == characterB.factions
    }

    companion object {
        private const val MAX_HEALTH: Float = 1000F
    }
}
