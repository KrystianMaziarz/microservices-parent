package pl.com.recipeservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.com.recipeservice.dto.*;
import pl.com.recipeservice.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecipesResponseGetAllDto> getAllRecipes() {

        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeResponseDto getRecipe(@PathVariable Long id) {

        return recipeService.getRecipe(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable Long id) {

        recipeService.deleteRecipe(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeResponseDto addNewRecipe(@RequestBody @Valid RecipeRequestDto recipeRequestDto) {

        return recipeService.addNewRecipe(recipeRequestDto);
    }

    @PutMapping({"/{recipeId}/ingredients"})
    @ResponseStatus(HttpStatus.OK)
    public RecipeResponseDto addNewIngredientsToRecipe(@PathVariable Long recipeId,
                                                       @RequestBody @Valid RecipeIngredientsRequestDto recipeIngredientsRequestDto) {

        return recipeService.addNewIngredientsToRecipe(recipeId, recipeIngredientsRequestDto);
    }

    @GetMapping("/{recipeId}/ingredients")
    @ResponseStatus(HttpStatus.OK)
    public List<RecipeIngredientsResponseDto> getRecipes(@PathVariable Long recipeId) {

        return recipeService.getAllRecipeIngredients(recipeId);
    }

    @DeleteMapping("/{recipeId}/ingredients/{ingredientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getRecipes(@PathVariable Long recipeId, @PathVariable Long ingredientId) {

        recipeService.deleteIngredientFromRecipe(recipeId,ingredientId);
    }

}
