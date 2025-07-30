package pl.com.recipeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.recipeservice.model.RecipeIngredientsEntity;

@Repository
public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredientsEntity, Long> {
}
