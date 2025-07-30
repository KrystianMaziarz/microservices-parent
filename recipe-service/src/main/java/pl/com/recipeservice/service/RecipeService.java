package pl.com.recipeservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.recipeservice.dto.RecipesResponseGetAllDto;
import pl.com.recipeservice.mapper.RecipeMapper;
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
                .map(recipeMapper::recipeToRecipeResponseGetAllDto)
                .collect(Collectors.toList());
    }
}
