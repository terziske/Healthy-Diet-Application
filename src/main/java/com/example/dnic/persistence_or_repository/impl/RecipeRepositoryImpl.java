package com.example.dnic.persistence_or_repository.impl;

import com.example.dnic.model.Recipe;
import com.example.dnic.persistence_or_repository.RecipeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private HashMap<Long, Recipe> recipes;
    private Long counter;



    @PostConstruct
    public void init() {
        this.counter = 0L;
        this.recipes = new HashMap<>();
        Long id = this.generateKey();
        this.recipes.put(id, new Recipe(id,"Turmeric Fish with Rice Noodles and Herbs", null, 1000, null));
        id = this.generateKey();
        this.recipes.put(id, new Recipe(id,"Amish Tomato Pie", null, 500,null));
        id = this.generateKey();
        this.recipes.put(id, new Recipe(id,"Classic Spicy Meatloaf", null, 500,null));
    }


    @Override
    public List<Recipe> findAll() {
        return new ArrayList<>(this.recipes.values());
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return Optional.ofNullable(this.recipes.get(id));
    }

    @Override
    public Recipe save(Recipe recipe) {
        if (recipe.getId() == null) {
            recipe.setId(this.generateKey());
        }
        this.recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public void deleteById(Long id) {
        this.recipes.remove(id);
    }

    private Long generateKey() {
        return ++counter;
    }
}
