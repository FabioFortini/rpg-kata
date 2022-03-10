class FactionsManager {
    private val factions: MutableMap<String, MutableSet<RPGCharacter>> = mutableMapOf()

    fun addCharacterToFaction(character: RPGCharacter, faction: String) {
        factions[faction] = mutableSetOf(character)
    }

    fun isCharacterMemberOf(character: RPGCharacter, faction: String): Boolean {
        return factions[faction]?.contains(character) ?: false
    }

}
