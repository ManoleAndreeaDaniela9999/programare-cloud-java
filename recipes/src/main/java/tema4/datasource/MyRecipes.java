package tema4.datasource;

import tema4.model.Ingredient;
import tema4.model.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyRecipes {

    private List<Recipe> recipeList;

    public MyRecipes() {

        List<Ingredient> list1 = Stream.of(
                new Ingredient("Milk", 500, "ml"),
                new Ingredient("Meat", 1500, "g"),
                new Ingredient("Tomatoes", 12, "pieces"),
                new Ingredient("Fries", 650, "g"),
                new Ingredient("Olive oil", 200, "ml")
        ).collect(Collectors.toList());
        List<Ingredient> list2 = Stream.of(
                new Ingredient("Egg", 3, "pieces"),
                new Ingredient("Meat", 1500, "g"),
                new Ingredient("Tomatoes", 12, "pieces"),
                new Ingredient("Fries", 650, "g"),
                new Ingredient("Olive oil", 200, "ml")
        ).collect(Collectors.toList());
        List<Ingredient> list3 = Stream.of(
                new Ingredient("Milk", 500, "ml"),
                new Ingredient("Meat", 5, "kg"),
                new Ingredient("Tomatoes", 12, "pieces"),
                new Ingredient("Fries", 650, "g"),
                new Ingredient("Sunflower oil", 200, "ml")
        ).collect(Collectors.toList());

        this.recipeList = Stream.of(
                new Recipe(list1, "recipe1"),
                new Recipe(list2, "recipe2"),
                new Recipe(list3, "recipe3")
        ).collect(Collectors.toList());

    }

    public List<Recipe> getAllRecipes() {
        return recipeList;
    }

    public Optional<Recipe> findRecipeByName(String name) {
        return recipeList.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Recipe saveRecipe(Recipe recipe) {
        findRecipeByName(recipe.getName()).ifPresent(i -> {
            throw new RuntimeException("Recipe with name " + i.getName() + " already exists!");
        });

        if (recipe.getName() == null || recipe.getName().isEmpty()) {
            throw new RuntimeException("Recipe name can not be null!");
        }

        for (Ingredient ingredient : recipe.getIngredientArrayList()) {
            if (ingredient.getName() == null || ingredient.getName().isEmpty()) {
                throw new RuntimeException("Ingredient name can not be null!");
            }
        }

        this.recipeList.add(recipe);

        return recipe;
    }

}
