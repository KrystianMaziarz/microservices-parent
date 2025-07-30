package pl.com.recipeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.recipeservice.dto.RecipesResponseGetAllDto;
import pl.com.recipeservice.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping ("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    public List<RecipesResponseGetAllDto> getAllRecipes() {


        return recipeService.getAllRecipes();
    }

}
