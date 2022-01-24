package com.example.dnic.model;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipeName;

    private Product product;

    private Integer quantity;

    private Unit unit;

    public Recipe() {
    }

    public Recipe(Long id, String recipeName, Product product, Integer quantity, Unit unit) {
        this.id = id;
        this.recipeName = recipeName;
        this.product = product;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
