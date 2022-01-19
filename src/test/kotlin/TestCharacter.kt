import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
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

    @Test
    fun `decrease health when received damage less than actual health`() {
        val character = Character()

        character.receiveDamage(200)
        character.receiveDamage(200)
        assertEquals(600, character.health)
    }

    @Test
    fun `die when received damage equal to health`() {
        val character = Character()

        character.receiveDamage(1000)
        assertEquals(0, character.health)
        assertFalse(character.alive)
    }

    @Test
    fun `die when received damage greather than health`() {
        val character = Character()

        character.receiveDamage(1500)
        assertEquals(0, character.health)
        assertFalse(character.alive)
    }

    @Test
    fun `character heal another character`() {
        val phabeeo = Character()
        val marco = Character()
        marco.receiveDamage(500)

        phabeeo.heal(marco, 200)

        assertEquals(700, marco.health)
    }

    @Test
    fun `character heal another character not over max health`() {
        val phabeeo = Character()
        val marco = Character()
        marco.receiveDamage(500)

        phabeeo.heal(marco, 800)

        assertEquals(1000, marco.health)
    }

    @Test
    fun `is not possible to heal a dead character`() {
        val character = Character()
        val deadCharacter = Character()
        deadCharacter.receiveDamage(1000)

        character.heal(deadCharacter, 1000)
        assertEquals(0, deadCharacter.health)
        assertFalse(deadCharacter.alive)
    }
    @Test
    fun `a character cannot deal damage to itself`() {
        val character = Character()
        character.dealDamage(character, 100)
        assertEquals(1000, character.health)
    }
}