import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestCharacter {
    @Test
    fun `should have 1000 health`() {
        val character = Character()

        assertEquals(1000, character.health)
    }
}