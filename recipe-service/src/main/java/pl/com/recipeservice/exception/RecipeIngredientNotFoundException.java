package pl.com.recipeservice.exception;

public class RecipeIngredientNotFoundException extends RuntimeException {
    public RecipeIngredientNotFoundException(Long id) {
        super("Recipe ingredient not found with id " + id);
    }

}
