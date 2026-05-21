package com.example.shop.repository;

import com.example.shop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1L, "Phone", 500));
        products.add(new Product(2L, "Laptop", 1200));
        products.add(new Product(3L, "Headphones", 100));
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void save(Product product) {
        products.add(product);
    }

    public boolean deleteById(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    public boolean update(Product updated) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(updated.getId())) {
                products.set(i, updated);
                return true;
            }
        }
        return false;
    }
}