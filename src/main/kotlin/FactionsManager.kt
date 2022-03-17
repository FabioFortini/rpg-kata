class FactionsManager {
    private val factions: MutableMap<String, MutableSet<RPGCharacter>> = mutableMapOf()

    fun addCharacterToFaction(character: RPGCharacter, faction: String) {
        if (factions.containsKey(faction)) {
            factions[faction]?.add(character)
        } else {
            factions[faction] = mutableSetOf(character)
        }
    }

    fun isCharacterMemberOf(character: RPGCharacter, faction: String): Boolean {
        return factions[faction]?.contains(character) ?: false
    }

    fun factionsOf(character: RPGCharacter): Set<String> {
        return factions.keys.filter { faction -> isCharacterMemberOf(character, faction) }.toSet()
    }

    fun removeCharacterFromFaction(character: RPGCharacter, faction: String) {
        factions[faction]?.remove(character)
    }

    fun areAllied(characterA: RPGCharacter, characterB: RPGCharacter): Boolean {
        val sameFactions = factionsOf(characterA).intersect(factionsOf(characterB))
        return sameFactions.isNotEmpty()
    }

}
