import java.lang.Integer.min

class Character {
    var health: Int = 1000
        private set
    var alive: Boolean = true
        private set
    val level: Int = 1

    fun receiveDamage(damage: Int) {
        health -= damage
        if(health <= 0)
            killed()
    }

    fun heal(target: Character, health: Int) {
        if(target.isDead())
            return
        target.health = min(target.health + health, 1000)
    }

    private fun isDead() = !alive

    private fun killed() {
        health = 0
        alive = false
    }
}
