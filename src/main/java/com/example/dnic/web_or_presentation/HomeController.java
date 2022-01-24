package com.example.dnic.web_or_presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String indexPage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHomePage(HttpServletResponse res, HttpServletRequest req) {
        return "Home";
    }

    @GetMapping("/diets")
    public String getDietsPage(HttpServletResponse res, HttpServletRequest req) {
        return "Diets";
    }

    @GetMapping("/water_tracker")
    public String getWaterTrackerPage(HttpServletResponse res, HttpServletRequest req) {
        return "Water Tracker";
    }

    @GetMapping("/recipes")
    public String getRecipesPage(HttpServletResponse res, HttpServletRequest req) {
        return "Recipes";
    }

    @GetMapping("/recipes/chicken_dishes")
    public String getChickenDishesPage(HttpServletResponse res, HttpServletRequest req) {
        return "Recipes (Chicken Dishes)";
    }

    @GetMapping("/recipes/chicken_dishes/chicken_salad_tacos")
    public String getChickenSaladTacosPage(HttpServletResponse res, HttpServletRequest req) {
        return "Recipes (Chicken Salad Tacos)";
    }

    @GetMapping("/BMI_calculator")
    public String getBMICalculatorPage(HttpServletResponse res, HttpServletRequest req) {
        return "BMI Calculator";
    }

    @GetMapping("/calorie_calculator")
    public String getCalorieCalculatorPage(HttpServletResponse res, HttpServletRequest req) {
        return "Calorie Calculator";
    }
}
