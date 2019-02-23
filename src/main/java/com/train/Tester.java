package com.train;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.print("Please enter number of tickets: ");
        Scanner scanner = new Scanner(System.in);
        int total_num = scanner.nextInt();
        System.out.print("How many round-trip tickets: ");
        int round_num = scanner.nextInt();
        Ticket ticket = new Ticket(total_num, round_num);
        ticket.print();
    }
}
