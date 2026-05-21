package com.example.shop.app;

import com.example.shop.cart.Cart;
import com.example.shop.config.AppConfig;
import com.example.shop.repository.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner = new Scanner(System.in);

        ProductRepository repo = context.getBean(ProductRepository.class);

        while (true) {
            System.out.println("\n1 - Show products");
            System.out.println("2 - Create new cart");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                repo.findAll().forEach(System.out::println);
            }

            else if (choice == 2) {
                Cart cart = context.getBean(Cart.class);

                while (true) {
                    System.out.println("\nCart menu:");
                    System.out.println("1 - Add product");
                    System.out.println("2 - Remove product");
                    System.out.println("3 - Show cart");
                    System.out.println("4 - Total price");
                    System.out.println("0 - Back");

                    int c = scanner.nextInt();

                    if (c == 1) {
                        System.out.print("Enter product id: ");
                        Long id = scanner.nextLong();
                        System.out.println(cart.addProduct(id) ? "Added" : "Not found");
                    }

                    else if (c == 2) {
                        System.out.print("Enter product id: ");
                        Long id = scanner.nextLong();
                        System.out.println(cart.removeProduct(id) ? "Removed" : "Not in cart");
                    }

                    else if (c == 3) {
                        cart.getItems().forEach(System.out::println);
                    }

                    else if (c == 4) {
                        System.out.println("Total: " + cart.totalPrice());
                    }

                    else if (c == 0) {
                        break;
                    }
                }
            }

            else if (choice == 0) {
                break;
            }
        }

        context.close();
    }
}