package com.example.client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server");
            while (true) {

                String input = scanner.nextLine();
                writer.println(input);
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
            }

        }
        catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
