package com.example.composedesignpattern.behavioral.strategy

fun main(args: Array<String>) {
    val h = OurHero()
    h.shoot()
    h.currentWeapon = Weapons.banana
    h.shoot()
}

object Weapons {
    val peashooter = fun(x: Int, y: Int, direction: Direction) {
        // Fly straight
    }

    val banana = fun(x: Int, y: Int, direction: Direction) {
        // Return when you hit screen border
    }

    val pomegranate = fun(x: Int, y: Int, direction: Direction) {
        // Explode when you hit first enemy
    }
}


class OurHero {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    var currentWeapon = Weapons.peashooter

    val shoot = fun() {
        currentWeapon(x, y, direction)
    }
}
