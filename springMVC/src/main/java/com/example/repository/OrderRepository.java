package com.example.repository;

import com.example.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private final Map<Long, Order> storage = new HashMap<>();
    private long idCounter = 1;

    public Order add(Order order) {
        order.setId(idCounter++);
        storage.put(order.getId(), order);
        return order;
    }

    public Order getById(Long id) {
        return storage.get(id);
    }

    public List<Order> getAll() {
        return new ArrayList<>(storage.values());
    }
}