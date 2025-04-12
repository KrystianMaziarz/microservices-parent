package com.pl.bakeryservice.controller;

import com.pl.bakeryservice.dto.ProductRequestDTO;
import com.pl.bakeryservice.dto.ProductResponse;
import com.pl.bakeryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequestDTO productRequestDTO) {

        return productService.createProduct(productRequestDTO);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts () {

        return productService.getAllProducts();
    }
}
