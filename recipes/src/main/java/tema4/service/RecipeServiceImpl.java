package tema4.service;

import tema4.datasource.MyRecipes;
import tema4.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecipeServiceImpl implements RecipeService {

    private final MyRecipes recipes;

    @Autowired
    public  RecipeServiceImpl(MyRecipes myRecipes){this.recipes=myRecipes;}

    @Override
    public List<Recipe> getAllRecipes() {
        return recipes.getAllRecipes();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipes.saveRecipe(recipe);
    }
}
