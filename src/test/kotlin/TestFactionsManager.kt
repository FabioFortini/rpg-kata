import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TestFactionsManager {
    @Test
    fun `join Faction`() {
        val character = RPGCharacter()
        val factionsManager = FactionsManager()

        factionsManager.addCharacterToFaction(character, "faction")

        assertTrue(factionsManager.isCharacterMemberOf(character, "faction"))
    }

    @Test
    fun `two characters join different Factions`() {
        val character1 = RPGCharacter()
        val character2 = RPGCharacter()
        val factionsManager = FactionsManager()

        factionsManager.addCharacterToFaction(character1, "faction1")
        factionsManager.addCharacterToFaction(character2, "faction2")

        assertTrue(factionsManager.isCharacterMemberOf(character1, "faction1"))
        assertTrue(factionsManager.isCharacterMemberOf(character2, "faction2"))
    }

    @Test
    fun `two characters join same Factions`() {
        val character1 = RPGCharacter()
        val character2 = RPGCharacter()
        val factionsManager = FactionsManager()

        factionsManager.addCharacterToFaction(character1, "faction")
        factionsManager.addCharacterToFaction(character2, "faction")

        assertTrue(factionsManager.isCharacterMemberOf(character1, "faction"))
        assertTrue(factionsManager.isCharacterMemberOf(character2, "faction"))
    }

}