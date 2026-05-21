package com.example.shop.cart;

import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private final ProductRepository productRepository;
    private final List<Product> items = new ArrayList<>();

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean addProduct(Long id) {
        return productRepository.findById(id)
                .map(items::add)
                .orElse(false);
    }

    public boolean removeProduct(Long id) {
        return items.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> getItems() {
        return items;
    }

    public double totalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}