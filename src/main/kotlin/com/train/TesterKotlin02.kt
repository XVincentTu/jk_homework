package com.train

import java.lang.NumberFormatException
import java.util.*
import javax.print.attribute.IntegerSyntax
import javax.management.Query.times

object OpConstansKotlin02 {
    const val SINGLE_PRICE = 1000;
    const val ROUND_PRICE = 1800;
}

fun main(args: Array<String>) {
    var total_num: Int
    var round_num: Int
    var times = 0
    var exception: Int
    var final_total_num = 0
    var final_round_num = 0
    var input: String
    val scanner = Scanner(System.`in`)
    do {
        total_num = 0; round_num = 0; times++; exception = 0;
        // Check Total Number of Tickets ( Single plus Round-Trip )
        println("=== Round " + times + " ===")
        println("If you want to exit the program, please type -1")
        print("Please enter number of tickets: ")
        input = scanner.next()
        try {
            total_num = Integer.parseInt(input)
            // Number of Tickets < 1 is illegal
            if (total_num == -1) {
                println("You press -1 and the program is going to exit now. Thank you.")
            } else if (total_num == 0 || total_num < -1) {
                println("Invalid Ticket Number! (Negative Number Wrong)")
            } else {
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
            }
        } catch (e: NumberFormatException) {
            // Number of Tickets must be Integer
            println("Invalid Ticket Number! (Non Integer Wrong)")
            exception = 1
        }
        total_num = if (total_num == -1) 0 else total_num
        round_num = if (total_num == 0) 0 else round_num
        var t = TesterKotlin02(total_num, round_num)
        final_total_num += total_num;
        final_round_num += round_num;
        t.print()
    } while (total_num != 0 || exception == 1)
    val ticketEnd = Ticket02(final_total_num, final_round_num)
    System.out.println("=== Final Statistics ( Total Round: $times) ===")
    ticketEnd.print()
}

class TesterKotlin02(var total_num: Int, var round_num: Int) {
    fun print() {
        val single_num = total_num - round_num;
        val total_price = single_num * OpConstansKotlin02.SINGLE_PRICE + round_num * OpConstansKotlin02.ROUND_PRICE

        val output = "Total ticket: " + total_num + "\n" +
                "Round-trip: " + round_num + "\n" +
                "Total: " + total_price

        println(output)
    }
}