package com.train

import java.util.*
import kotlin.math.sin

object OpConstansKotlin {
    const val SINGLE_PRICE = 1000;
    const val ROUND_PRICE = 1800;
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    print("Please enter number of tickets: ")
    val total_num = scanner.nextInt()
    print("How many round-trip tickets: ")
    val round_num = scanner.nextInt()
    var t = TesterKotlin(total_num, round_num)
    t.print()
}

class TesterKotlin(var total_num: Int, var round_num: Int) {
    fun print() {
        val single_num = total_num - round_num;
        val total_price = single_num * OpConstansKotlin.SINGLE_PRICE + round_num * OpConstansKotlin.ROUND_PRICE

        val output = "Total ticket: " + total_num + "\n" +
                "Round-trip: " + round_num + "\n" +
                "Total: " + total_price

        println(output)
    }
}