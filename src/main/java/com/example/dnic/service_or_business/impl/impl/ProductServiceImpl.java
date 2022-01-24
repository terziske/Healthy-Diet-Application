package com.example.dnic.service_or_business.impl.impl;

import com.example.dnic.model.Product;
import com.example.dnic.model.exception.ProductNotFoundException;
import com.example.dnic.persistence_or_repository.ProductRepository;
import com.example.dnic.service_or_business.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
