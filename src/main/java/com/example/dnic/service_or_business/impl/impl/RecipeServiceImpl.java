package com.example.dnic.service_or_business.impl.impl;

import com.example.dnic.model.Product;
import com.example.dnic.model.Recipe;
import com.example.dnic.model.Unit;
import com.example.dnic.model.exception.RecipeNotFoundException;
import com.example.dnic.persistence_or_repository.RecipeRepository;
import com.example.dnic.service_or_business.impl.ProductService;
import com.example.dnic.service_or_business.impl.RecipeService;
import com.example.dnic.service_or_business.impl.UnitService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ProductService productService;
    private final UnitService unitService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ProductService productService, UnitService unitService) {
        this.recipeRepository = recipeRepository;
        this.productService = productService;
        this.unitService = unitService;
    }

    @Override
    public List<Recipe> findAll() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return this.recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @Override
    public Recipe saveRecipe(String recipeName, Long productId, Integer quantity, Long unitId) {
        Product product = this.productService.findById(productId);
        Unit unit = this.unitService.findById(unitId);
        Recipe recipe = new Recipe(null, recipeName, product, quantity, unit);
        return this.recipeRepository.save(recipe);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) throws IOException {
        Product product = this.productService.findById(recipe.getProduct().getId());
        Unit unit = this.unitService.findById(recipe.getUnit().getId());
        recipe.setProduct(product);
        recipe.setUnit(unit);
        return this.recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long id) {
        this.recipeRepository.deleteById(id);
    }
}
