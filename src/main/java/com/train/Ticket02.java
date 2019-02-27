package com.train;

public class Ticket02 {
    public static final int SINGLE_PRICE = 1000;
    public static final int ROUND_PRICE = 1800;
    int total_num;
    int round_num;

    public Ticket02(int total_num, int round_num) {
        this.total_num = total_num;
        this.round_num = round_num;
    }

    public void print() {
        int single_num = total_num - round_num;
        int total_price = single_num * SINGLE_PRICE + round_num * ROUND_PRICE;

        System.out.println("Total ticket: " + total_num + "\n" +
                "Round-trip: " + round_num + "\n" +
                "Total: " + total_price);
    }
}
