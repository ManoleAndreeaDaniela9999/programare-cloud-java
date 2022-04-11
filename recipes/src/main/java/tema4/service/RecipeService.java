package tema4.service;

import tema4.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();
    Recipe saveRecipe(Recipe recipe);
}
