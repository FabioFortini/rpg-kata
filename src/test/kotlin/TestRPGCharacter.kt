import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class TestRPGCharacter {
    @Test
    fun `should have 1000 health`() {
        val character = RPGCharacter()

        assertEquals(1000, character.health)
    }

    @Test
    fun `should have 1 as level`() {
        val character = RPGCharacter()

        assertEquals(1, character.level)
    }

    @Test
    fun `should be alive`() {
        val character = RPGCharacter()

        assertTrue(character.alive)
    }

    @Test
    fun `decrease health on each damage received`() {
        val target = RPGCharacter()

        RPGCharacter().dealDamage(target, 200)
        RPGCharacter().dealDamage(target, 200)

        assertEquals(600, target.health)
    }

    @Test
    fun `health becomes zero when damage greather than health`() {
        val target = RPGCharacter()

        RPGCharacter().dealDamage(target, 1100)

        assertEquals(0, target.health)
    }

    @Test
    fun `die when received damage equal to health`() {
        val target = RPGCharacter()

        RPGCharacter().dealDamage(target, 1000)

        assertFalse(target.alive)
    }

    @Test
    fun `die when received damage greather than health`() {
        val character = RPGCharacter()

        RPGCharacter().dealDamage(character, 1500)

        assertFalse(character.alive)
    }

    @Test
    fun `character can heal itself`() {
        val target = RPGCharacter()
        RPGCharacter().dealDamage(target, 500)

        target.heal(target, 200)

        assertEquals(700, target.health)
    }

    @Test
    fun `character cannot heal itself over max health`() {
        val target = RPGCharacter()
        RPGCharacter().dealDamage(target, 500)

        target.heal(target, 800)

        assertEquals(1000, target.health)
    }

    @Test
    fun `is not possible to heal a dead character`() {
        val deadCharacter = RPGCharacter()
        RPGCharacter().dealDamage(deadCharacter, 1000)

        deadCharacter.heal(deadCharacter, 1000)

        assertEquals(0, deadCharacter.health)
        assertFalse(deadCharacter.alive)
    }

    @Test
    fun `a character cannot deal damage to itself`() {
        val character = RPGCharacter()

        character.dealDamage(character, 100)

        assertEquals(1000, character.health)
    }
}