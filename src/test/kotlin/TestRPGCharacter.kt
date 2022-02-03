import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class TestRPGCharacter {
    @Test
    fun `should have 1000 health`() {
        val character = RPGCharacter()

        assertEquals(1000F, character.health)
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

        assertEquals(600F, target.health)
    }

    @Test
    fun `health becomes zero when damage greather than health`() {
        val target = RPGCharacter()

        RPGCharacter().dealDamage(target, 1100)

        assertEquals(0F, target.health)
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
        val target = createCharacter(damageReceived = 500)

        target.heal(200)

        assertEquals(700F, target.health)
    }

    @Test
    fun `character cannot heal itself over max health`() {
        val target = createCharacter(damageReceived = 500)

        target.heal(800)

        assertEquals(1000F, target.health)
    }

    @Test
    fun `is not possible to heal a dead character`() {
        val deadCharacter = createCharacter(damageReceived = 1000)

        deadCharacter.heal(1000)

        assertEquals(0F, deadCharacter.health)
        assertFalse(deadCharacter.alive)
    }

    @Test
    fun `a character cannot deal damage to itself`() {
        val character = RPGCharacter()

        character.dealDamage(character, 100)

        assertEquals(1000F, character.health)
    }

    private fun createCharacter(damageReceived: Int): RPGCharacter {
        val target = RPGCharacter()
        RPGCharacter().dealDamage(target, damageReceived)
        return target
    }

    @Test
    fun `damage is reduced by 50% when target is 5 levels above`() {
        val character = RPGCharacter()
        val target = RPGCharacter(6)

        character.dealDamage(target, 100)

        assertEquals(950F, target.health)
    }

    @Test
    fun `damage is increased by 50% when target is 5 levels below`() {
        val character = RPGCharacter(6)
        val target = RPGCharacter()

        character.dealDamage(target, 100)

        assertEquals(850F, target.health)
    }

    @Test
    fun `handle odd numbers in damage when target is 5 levels below`() {
        val character = RPGCharacter(6)
        val target = RPGCharacter(1)

        character.dealDamage(target, 1)

        assertEquals(998.5F, target.health)
    }

    @Test
    fun `handle odd numbers in damage when target is 5 levels above`() {
        val character = RPGCharacter(1)
        val target = RPGCharacter(6)

        character.dealDamage(target, 1)

        assertEquals(999.5F, target.health)
    }

    @Test
    fun `Melee fighters have a range of 2 meters`() {
        val melee = RPGCharacter()

        assertEquals(2, melee.maxRange)
    }


}