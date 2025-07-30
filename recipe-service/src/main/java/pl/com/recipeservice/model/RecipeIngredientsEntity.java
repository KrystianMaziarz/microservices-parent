package pl.com.recipeservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "recipe_ingredients")
public class RecipeIngredientsEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String ingredientName;
    private Double quantity;
    private String unit;

    @ManyToOne (cascade = CascadeType.ALL)
    private RecipeEntity recipe;

}
