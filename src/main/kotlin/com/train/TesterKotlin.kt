package com.train

import java.lang.NumberFormatException
import java.util.*
import javax.print.attribute.IntegerSyntax
import kotlin.math.sin

object OpConstansKotlin {
    const val SINGLE_PRICE = 1000;
    const val ROUND_PRICE = 1800;
}

fun main(args: Array<String>) {
    var total_num = -1
    var round_num = -1
    var input: String
    val scanner = Scanner(System.`in`)
    do {
        // Check Total Number of Tickets ( Single plus Round-Trip )
        print("Please enter number of tickets: ")
        input = scanner.next()
        try {
            total_num = Integer.parseInt(input)
            // Number of Tickets < 1 is illegal
            if (total_num < 1) {
                println("Invalid Ticket Number! (Negative Number Wrong)")
            }
        } catch (e: NumberFormatException) {
            // Number of Tickets must be Integer
            println("Invalid Ticket Number! (Non Integer Wrong)")
        }
    } while (total_num < 1)
    do {
        // Check Total Round-Trip Number of Tickets
        print("How many round-trip tickets: ")
        input = scanner.next()
        try {
            round_num = Integer.parseInt(input)
            // Number of Tickets < 1 is illegal
            if (round_num < 1) {
                println("Invalid Round-Trip Tickets! (Negative Number Wrong)")
            // Number of Round-Trip Tickets must be lower than Number of Total Tickets
            } else if (round_num > total_num) {
                println("Invalid Round-Trip Tickets! (Round-Trip Tickets> Total Tickets)")
            }
        } catch (e: NumberFormatException) {
            // Number of Tickets must be Integer
            println("Invalid Round-Trip Tickets! (Non Integer Wrong)")
        }
    } while (round_num < 1 || round_num > total_num)
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