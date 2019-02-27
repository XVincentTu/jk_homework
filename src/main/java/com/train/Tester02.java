package com.train;

import java.util.Scanner;

public class Tester02 {
    public static void main(String[] args) {
        int total_num, round_num, times = 0, exception;
        int final_total_num = 0, final_round_num = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            total_num = 0; round_num = 0; times++; exception = 0;
            // Check Total Number of Tickets ( Single plus Round-Trip )
            System.out.println("=== Round " + times + " ===");
            System.out.println("If you want to exit the program, please type -1");
            System.out.print("Please enter number of tickets: ");
            String input = scanner.next();
            try {
                total_num = Integer.parseInt(input);
                // Number of Tickets < 1 is illegal
                if (total_num == -1) {
                    System.out.println("You press -1 and the program is going to exit now. Thank you.");
                    //System.exit(0);
                } else if (total_num == 0 || total_num < -1) {
                    System.out.println("Invalid Ticket Number! (Zero or Negative Number Wrong)");
                } else {
                    do {
                        // Check Total Round-Trip Number of Tickets
                        System.out.print("How many round-trip tickets: ");
                        input = scanner.next();
                        try {
                            round_num= Integer.parseInt(input);
                            // Number of Tickets < 1 is illegal
                            if (round_num < 1) {
                                System.out.println("Invalid Round-Trip Tickets! (Negative Number Wrong)");
                                // Number of Round-Trip Tickets must be lower than Number of Total Tickets
                            } else if (round_num > total_num) {
                                System.out.println("Invalid Round-Trip Tickets! (Round-Trip Tickets> Total Tickets)");
                            }
                        } catch (NumberFormatException e) {
                            // Number of Tickets must be Integer
                            System.out.println("Invalid Round-Trip Tickets! (Non Integer Wrong)");
                        }
                    } while (round_num < 1 || round_num > total_num);
                }
            } catch (NumberFormatException e) {
                // Number of Tickets must be Integer
                System.out.println("Invalid Ticket Number! (Non Integer Wrong)");
                exception = 1;
            }
            total_num = (total_num == -1) ? 0 : total_num;
            round_num = (total_num == 0) ? 0 : round_num;
            Ticket02 ticket = new Ticket02(total_num, round_num);
            final_total_num += total_num;
            final_round_num += round_num;
            ticket.print();
        } while (total_num != 0 || exception == 1);
        // Print out the statistics information
        Ticket02 ticketEnd = new Ticket02(final_total_num, final_round_num);
        System.out.println("=== Final Statistics ( Total Round: " + times + ") ===");
        ticketEnd.print();
    }
}
