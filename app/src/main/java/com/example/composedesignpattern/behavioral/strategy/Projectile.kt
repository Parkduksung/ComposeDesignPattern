package com.example.composedesignpattern.behavioral.strategy
abstract class Projectile(private val x: Int,
                          private val y: Int,
                          private val direction: Direction) {

}

enum class Direction {
    LEFT, RIGHT
}