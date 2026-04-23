package com.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.LinkedList;
import java.util.List;

public class CoffeeOrderBoard {
    private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);
    private final List<Order> orders = new LinkedList<>();
    private int nextNumber = 1;

    public void add(String name) {
        Order order = new Order(nextNumber++, name);
        orders.add(order);
        logger.info("Added order: {} | {}", order.getNumber(), order.getName());
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("Queue is empty");
            return null;
        }
        Order order = orders.remove(0);
        logger.info("Delivered: {} | {}", order.getNumber(), order.getName());
        return order;
    }

    public Order deliver(int number) {
        try {
            for (Order order : orders) {
                if (order.getNumber() == number) {
                    orders.remove(order);

                    logger.info("Delivered specific: {} | {}", order.getNumber(), order.getName());
                    return order;
                }
            }
            throw new RuntimeException("Order not found: " + number);
        } catch (Exception e) {
            logger.error("Error delivering order", e);
            return null;
        }
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
        logger.debug("Queue size: {}", orders.size());
    }
}