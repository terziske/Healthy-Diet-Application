package com.example.dnic.persistence_or_repository.impl;

import com.example.dnic.model.Product;
import com.example.dnic.persistence_or_repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private HashMap<Long, Product> products;

    public ProductRepositoryImpl() {
        this.products = new HashMap<>();
        Product p1 = new Product(1L, "Raw Fish");
        Product p2 = new Product(2L, "Fish Oil");
        Product p3 = new Product(3L, "Tomato");
        Product p4 = new Product(4L, "Salt");
        Product p5 = new Product(5L, "Thyme");
        Product p6 = new Product(6L, "Meat");
        Product p7 = new Product(7L, "Cucumber");
        Product p8 = new Product(8L, "Lemon");
        this.products.put(p1.getId(), p1);
        this.products.put(p2.getId(), p2);
        this.products.put(p3.getId(), p3);
        this.products.put(p4.getId(), p4);
        this.products.put(p5.getId(), p5);
        this.products.put(p6.getId(), p6);
        this.products.put(p7.getId(), p7);
        this.products.put(p8.getId(), p8);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(this.products.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(this.products.get(id));
    }
}
