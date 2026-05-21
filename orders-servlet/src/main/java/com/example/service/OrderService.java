package com.example.service;

import com.example.model.Order;
import java.util.HashMap;
import java.util.Map;

public class OrderService {

    private final Map<Long, Order> orders = new HashMap<>();

    public void create(Order order) {
        orders.put(order.getId(), order);
    }

    public Order getById(Long id) {
        return orders.get(id);
    }

    public void update(Order order) {
        orders.put(order.getId(), order);
    }

    public void delete(Long id) {
        orders.remove(id);
    }
}