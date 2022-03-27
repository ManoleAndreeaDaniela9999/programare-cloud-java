package tema4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe {
    private List<Ingredient> ingredientArrayList;
    private String name;

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }
}
