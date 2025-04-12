package com.pl.bakeryservice.service;

import com.pl.bakeryservice.dto.ProductRequestDTO;
import com.pl.bakeryservice.dto.ProductResponse;
import com.pl.bakeryservice.model.ProductEntity;
import com.pl.bakeryservice.repository.ProductRepository;
import com.pl.bakeryservice.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequestDTO productRequestDTO) {

        ProductEntity productEntity = ProductEntity.builder().name(productRequestDTO.name()).price(productRequestDTO.price()).build();

        ProductEntity save = productRepository.save(productEntity);
        log.info("Product {} is saved", productEntity.getName());

        return new ProductResponse(save.getName(), save.getPrice());
    }

    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll().stream().map(productMapper::mapToProductResponse).toList();
    }

    public ProductEntity getProductOrCreateNew(Long id) {

        ProductEntity productEntity = productRepository.findById(id).orElse(new ProductEntity());

        productRepository.save(productEntity);


    }
}
