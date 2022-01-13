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

    private fun killed() {
        health = 0
        alive = false
    }
}