package com.example.composedesignpattern.behavioral.strategy

class OurHeroJavaWay {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    private var currentWeapon: Weapon = Peashooter()

    fun shoot(): Projectile = currentWeapon.shoot(x, y, direction)

    fun equip(weapon: Weapon) {
        currentWeapon = weapon
    }
}


interface Weapon {
    fun shoot(
        x: Int,
        y: Int,
        direction: Direction
    ): Projectile
}

class Peashooter : Weapon {
    override fun shoot(
        x: Int,
        y: Int,
        direction: Direction
    ) = object : Projectile(x, y, direction) {
        // Fly straight
    }
}

class Pomegranate : Weapon {
    override fun shoot(
        x: Int,
        y: Int,
        direction: Direction
    ) = object : Projectile(x, y, direction) {
        // Explode when you hit first enemy
    }
}

class Banana : Weapon {
    override fun shoot(
        x: Int,
        y: Int,
        direction: Direction
    ) = object : Projectile(x, y, direction) {
        // Return when you hit screen border
    }
}