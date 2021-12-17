class Character {
    var health: Int = 1000
        private set

    val level: Int = 1
    val alive: Boolean = true

    fun receiveDamage(damage: Int) {
        health -= damage
    }
}