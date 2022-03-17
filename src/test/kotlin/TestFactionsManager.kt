import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
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

    @Test
    fun `a character can join more than one faction`() {
        val character = RPGCharacter()
        val factionsManager = FactionsManager()

        factionsManager.addCharacterToFaction(character, "faction1")
        factionsManager.addCharacterToFaction(character, "faction2")

        assertEquals(setOf("faction1", "faction2"), factionsManager.factionsOf(character))
    }

    @Test
    fun `Newly created character belongs to no faction`() {
        val character = RPGCharacter()
        val factionsManager = FactionsManager()

        assertEquals(emptySet<String>(), factionsManager.factionsOf(character))
    }

    @Test
    fun `a character can leave a faction`() {
        val character = RPGCharacter()
        val factionsManager = FactionsManager()
        factionsManager.addCharacterToFaction(character, "faction1")

        factionsManager.removeCharacterFromFaction(character, "faction1")

        assertEquals(emptySet<String>(), factionsManager.factionsOf(character))
    }

    @Test
    fun `a character can leave one of multiple factions`() {
        val character = RPGCharacter()
        val factionsManager = FactionsManager()
        factionsManager.addCharacterToFaction(character, "faction")
        factionsManager.addCharacterToFaction(character, "another faction")

        factionsManager.removeCharacterFromFaction(character, "another faction")

        assertEquals(setOf("faction"), factionsManager.factionsOf(character))
    }

    @Test
    fun `players belonging to the same Faction are considered Allies`() {
        val characterA = RPGCharacter()
        val characterB = RPGCharacter()
        val factionsManager = FactionsManager()
        factionsManager.addCharacterToFaction(characterA, "faction")
        factionsManager.addCharacterToFaction(characterB, "faction")

        assertTrue(factionsManager.areAllied(characterA, characterB));
    }

    @Test
    fun `players belonging to the different Factions are not considered Allies`() {
        val characterA = RPGCharacter()
        val characterB = RPGCharacter()
        val factionsManager = FactionsManager()
        factionsManager.addCharacterToFaction(characterA, "factionA")
        factionsManager.addCharacterToFaction(characterB, "factionB")

        assertFalse(factionsManager.areAllied(characterA, characterB));
    }


}