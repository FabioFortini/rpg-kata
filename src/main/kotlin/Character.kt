class Character {
    var health: Int = 1000
        private set

    val level: Int = 1
    var alive: Boolean = true
        private set

    fun receiveDamage(damage: Int) {
        health -= damage
        if(health == 0)
            alive = false
    }
}