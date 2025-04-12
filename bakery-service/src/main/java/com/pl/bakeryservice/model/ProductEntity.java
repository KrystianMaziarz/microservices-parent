package com.pl.bakeryservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigInteger price;

}
