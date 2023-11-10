package com.example.composedesignpattern.behavioral.strategy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test


class OurHeroTest {

    @Test
    fun testStrategy() {
        val ourHero = OurHero()

        assertEquals(ourHero.currentWeapon.javaClass, Weapons.peashooter.javaClass)

        ourHero.currentWeapon = Weapons.banana

        assertNotEquals(ourHero.currentWeapon.javaClass, Weapons.peashooter.javaClass)
        assertEquals(ourHero.currentWeapon.javaClass, Weapons.banana.javaClass)

        ourHero.currentWeapon = Weapons.pomegranate

        assertNotEquals(ourHero.currentWeapon.javaClass, Weapons.banana.javaClass)
        assertEquals(ourHero.currentWeapon.javaClass, Weapons.pomegranate.javaClass)

    }
}