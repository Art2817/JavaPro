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
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }


    @PostMapping
    public Order create(@RequestBody Order order) {
        return repository.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order updated) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setProducts(updated.getProducts());
        order.setTotalCost(updated.getTotalCost());

        return repository.save(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}