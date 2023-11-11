package com.example.composedesignpattern.behavioral.command

fun main(args: Array<String>) {

    val s = Soldier()
    s.appendMove(20, 0)
        .appendAttack(20, 20)
        .appendMove(20, 20)
        .appendAttack(40, 10)
        .appendMove(5, 20)
        .execute()
}

val moveGenerator = fun(s: Soldier, x: Int, y: Int): Command {
    return fun() {
        s.move(x, y)
    }
}

val attackGenerator = fun(s: Soldier, x: Int, y: Int): Command {
    return fun() {
        s.attack(x, y)
    }
}


class Soldier {

    private val commands = mutableListOf<Command>()


    fun execute() {
        while (commands.isNotEmpty()) {
            val command = commands.removeAt(0)
            command.invoke()
        }
    }

    fun move(x: Int, y: Int) {
        println("Moving to ($x, $y)")
    }

    fun attack(x: Int, y: Int) {
        println("Attacking ($x, $y)")
    }


    fun appendMove(x: Int, y: Int) = apply {
        commands.add(moveGenerator(this, x, y))
    }

    fun appendAttack(x: Int, y: Int) = apply {
        commands.add(attackGenerator(this, x, y))
    }

}


typealias Command = () -> Unit