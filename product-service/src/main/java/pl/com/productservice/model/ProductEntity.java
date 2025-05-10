package pl.com.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer quantityInStock;
    private Integer minStockThreshold;
    private Long recipeId;
    private BigInteger price;

    @ManyToOne
    private CategoryEntity category;

}
