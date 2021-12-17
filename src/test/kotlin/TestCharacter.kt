import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TestCharacter {
    @Test
    fun `should have 1000 health`() {
        val character = Character()

        assertEquals(1000, character.health)
    }

    @Test
    fun `should have 1 as level`() {
        val character = Character()

        assertEquals(1, character.level)
    }

    @Test
    fun `should be alive`() {
        val character = Character()

        assertTrue(character.alive)
    }
}