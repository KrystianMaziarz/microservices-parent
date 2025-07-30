package pl.com.recipeservice.dto;

import java.util.List;

public record RecipeResponseDto(String name, String description, List<RecipeIngredientsResponseDto> ingredientsResponseDto) {

}
