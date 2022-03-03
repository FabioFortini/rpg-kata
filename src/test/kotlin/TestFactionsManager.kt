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

}