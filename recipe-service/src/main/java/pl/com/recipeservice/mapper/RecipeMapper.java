package pl.com.recipeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.recipeservice.dto.*;
import pl.com.recipeservice.model.RecipeEntity;
import pl.com.recipeservice.model.RecipeIngredientsEntity;

@Mapper (componentModel = "spring")
public interface RecipeMapper {

    RecipesResponseGetAllDto mapRecipeToRecipeResponseGetAllDto(RecipeEntity recipe);

    @Mapping(source = "ingredients", target = "ingredientsResponseDto")
    RecipeResponseDto mapRecipeToRecipeResponseDto(RecipeEntity recipe);

    RecipeIngredientsResponseDto mapToDto(RecipeIngredientsEntity entity);

    RecipeEntity mapRecipeRequestDtoToRecipeEntity(RecipeRequestDto recipeRequestDto);

    RecipeIngredientsEntity mapIngredientsDtoToEntity(RecipeIngredientsRequestDto ingredientsRequestDto);
}
