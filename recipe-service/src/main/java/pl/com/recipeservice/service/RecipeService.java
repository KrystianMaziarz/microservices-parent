package pl.com.recipeservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.recipeservice.dto.*;
import pl.com.recipeservice.exception.RecipeIngredientNotFoundException;
import pl.com.recipeservice.exception.RecipeNotFoundException;
import pl.com.recipeservice.mapper.RecipeMapper;
import pl.com.recipeservice.model.RecipeEntity;
import pl.com.recipeservice.model.RecipeIngredientsEntity;
import pl.com.recipeservice.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public List<RecipesResponseGetAllDto> getAllRecipes() {

        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::mapRecipeToRecipeResponseGetAllDto)
                .collect(Collectors.toList());
    }

    public RecipeResponseDto getRecipe(Long id) {

        RecipeEntity recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id)
                );

        return recipeMapper.mapRecipeToRecipeResponseDto(recipe);
    }

    public void deleteRecipe(Long id) {

        recipeRepository.deleteById(id);
    }

    public RecipeResponseDto addNewRecipe(RecipeRequestDto recipeRequestDto) {

        RecipeEntity recipeEntity = recipeMapper.mapRecipeRequestDtoToRecipeEntity(recipeRequestDto);

        recipeRepository.save(recipeEntity);

        return recipeMapper.mapRecipeToRecipeResponseDto(recipeEntity);
    }

    @Transactional
    public RecipeResponseDto addNewIngredientsToRecipe(Long recipeId, RecipeIngredientsRequestDto dto) {

        RecipeEntity recipeEntity = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        RecipeIngredientsEntity ingredient = recipeMapper.mapIngredientsDtoToEntity(dto);

        recipeEntity.addIngredient(ingredient);

        return recipeMapper.mapRecipeToRecipeResponseDto(recipeEntity);
    }

    public List<RecipeIngredientsResponseDto> getAllRecipeIngredients(Long recipeId) {

        RecipeEntity recipeEntity = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        RecipeResponseDto recipeResponseDto = recipeMapper.mapRecipeToRecipeResponseDto(recipeEntity);

        return recipeResponseDto.ingredientsResponseDto();
    }

    @Transactional
    public void deleteIngredientFromRecipe(Long recipeId, Long ingredientId) {

        RecipeEntity recipeEntity = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        RecipeIngredientsEntity ingredientToRemove = recipeEntity.getIngredients().stream().filter(i -> i.getId().equals(ingredientId))
                .findFirst().orElseThrow(() -> new RecipeIngredientNotFoundException(ingredientId));

        recipeEntity.getIngredients().remove(ingredientToRemove);
    }
}
