package com.example.dnic.service_or_business.impl;

import com.example.dnic.model.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RecipeService {
    List<Recipe> findAll();
    Recipe findById(Long id);
    Recipe saveRecipe(String recipeName, Long productId, Integer quantity, Long unitId);
    Recipe saveRecipe(Recipe recipe) throws IOException;
    void deleteById(Long id);
}
