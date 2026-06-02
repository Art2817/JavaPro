package com.example.controller;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> getAll() {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return repository.getById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return repository.add(order);
    }
}