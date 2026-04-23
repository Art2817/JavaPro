package com.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Artem");
        board.add("Alex");
        board.add("Maria");
        board.add("Tom");
        board.draw();

        System.out.println("\nDeliver first:");
        board.deliver();
        board.draw();

        System.out.println("\nDeliver by number 3:");
        board.deliver(3);
        board.draw();

        System.out.println("\nTry wrong number:");
        board.deliver(99);
    }
}