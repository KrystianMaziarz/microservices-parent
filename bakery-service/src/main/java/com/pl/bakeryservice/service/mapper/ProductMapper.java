package com.pl.bakeryservice.service.mapper;

import com.pl.bakeryservice.dto.ProductResponse;
import com.pl.bakeryservice.model.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
//TODO zmienić to na mapstructa
    public ProductResponse mapToProductResponse(ProductEntity productEntity) {

        return new ProductResponse(productEntity.getName(),productEntity.getPrice());
    }
}
