package pl.com.recipeservice.mapper;

import org.mapstruct.Mapper;
import pl.com.recipeservice.dto.RecipesResponseGetAllDto;
import pl.com.recipeservice.model.RecipeEntity;

@Mapper
public interface RecipeMapper {

    RecipesResponseGetAllDto recipeToRecipeResponseGetAllDto(RecipeEntity recipe);
}
