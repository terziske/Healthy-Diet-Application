package com.example.dnic.persistence_or_repository;

import com.example.dnic.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
