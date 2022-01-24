package com.example.dnic.web_or_presentation;

import com.example.dnic.model.Product;
import com.example.dnic.model.Recipe;
import com.example.dnic.model.Unit;
import com.example.dnic.service_or_business.impl.ProductService;
import com.example.dnic.service_or_business.impl.RecipeService;
import com.example.dnic.service_or_business.impl.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/created_recipes")
public class RecipeController {

    private RecipeService recipeService;
    private ProductService productService;
    private UnitService unitService;

    public RecipeController(RecipeService recipeService, ProductService productService, UnitService unitService) {
        this.recipeService = recipeService;
        this.productService = productService;
        this.unitService = unitService;
    }

    @GetMapping
    public String getRecipePage(Model model) {
        List<Recipe> recipes = this.recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "Created_Recipes";
    }


    @GetMapping("/create_recipe")
    public String addNewRecipePage(Model model) {
        List<Product> products = this.productService.findAll();
        List<Unit> units = this.unitService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("units", units);
        model.addAttribute("recipe", new Recipe());
        return "Create_Recipe";
    }

    @GetMapping("/{id}/edit")
    public String editProductPage(Model model, @PathVariable Long id) {
        try {
            Recipe recipe = this.recipeService.findById(id);
            List<Product> products = this.productService.findAll();
            List<Unit> units = this.unitService.findAll();
            model.addAttribute("recipe", recipe);
            model.addAttribute("products", products);
            model.addAttribute("units", units);
            return "Create_Recipe";
        } catch (RuntimeException ex) {
            return "redirect:/create_recipes?error=" + ex.getMessage();
        }
    }

    @PostMapping
    public String saveRecipe(
            @Valid Recipe recipe,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            List<Product> products = this.productService.findAll();
            List<Unit> units = this.unitService.findAll();
            model.addAttribute("products", products);
            model.addAttribute("units", units);
            return "Create_Recipe";
        }
        try {
            this.recipeService.saveRecipe(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/created_recipes";
    }

    @PostMapping("/{id}/delete")
    public String deleteRecipeWithPost(@PathVariable Long id) {
        this.recipeService.deleteById(id);
        return "redirect:/created_recipes";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteRecipeWithDelete(@PathVariable Long id) {
        this.recipeService.deleteById(id);
        return "redirect:/created_recipes";
    }
}

