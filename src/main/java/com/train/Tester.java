package com.train;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        int total_num = -1, round_num = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            // Check Total Number of Tickets ( Single plus Round-Trip )
            System.out.print("Please enter number of tickets: ");
            String input = scanner.next();
            try {
                total_num = Integer.parseInt(input);
                // Number of Tickets < 1 is illegal
                if (total_num < 1) {
                    System.out.println("Invalid Ticket Number! (Negative Number Wrong)");
                }
            } catch (NumberFormatException e) {
                // Number of Tickets must be Integer
                System.out.println("Invalid Ticket Number! (Non Integer Wrong)");
            }
        } while (total_num < 1);
        do {
            // Check Total Round-Trip Number of Tickets
            System.out.print("How many round-trip tickets: ");
            String input = scanner.next();
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
        Ticket ticket = new Ticket(total_num, round_num);
        ticket.print();
    }
}
