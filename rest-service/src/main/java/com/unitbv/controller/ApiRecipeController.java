package com.unitbv.controller;

import com.unitbv.model.Ingredient;
import com.unitbv.request.CreateRecipeRequest;
import com.unitbv.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class ApiRecipeController {

    private final RecipeService recipeService;

    @Autowired
    public ApiRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CreateRecipeRequest>> getAllReceipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }


    @PostMapping("/new")
    public ResponseEntity saveRecipe(@RequestBody CreateRecipeRequest recipe){

        try {
            return ResponseEntity.ok( recipeService.saveRecipe( recipe));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

}
