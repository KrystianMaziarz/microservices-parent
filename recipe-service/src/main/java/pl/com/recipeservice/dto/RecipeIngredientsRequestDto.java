package pl.com.recipeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record RecipeIngredientsRequestDto(
        @NotBlank(message = "Ingredient name must not be blank") String ingredientName,
        @Positive(message = "Quantity must be positive") double quantity,
        @NotBlank(message = "Unity must not be blank") String unit) {
}
