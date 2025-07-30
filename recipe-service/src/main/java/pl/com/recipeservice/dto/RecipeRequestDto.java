package pl.com.recipeservice.dto;

import jakarta.validation.constraints.NotBlank;

public record RecipeRequestDto(
        @NotBlank(message = "Name must not be blank") String name,
        @NotBlank(message = "description must not be blank") String description) {
}
