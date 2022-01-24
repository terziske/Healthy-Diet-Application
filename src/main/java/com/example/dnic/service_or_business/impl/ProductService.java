package com.example.dnic.service_or_business.impl;

import com.example.dnic.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
