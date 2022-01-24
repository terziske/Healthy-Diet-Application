package com.example.dnic.persistence_or_repository;

import com.example.dnic.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {
    List<Recipe> findAll();
    Optional<Recipe> findById(Long id);
    Recipe save(Recipe recipe);
    void deleteById(Long id);
}

