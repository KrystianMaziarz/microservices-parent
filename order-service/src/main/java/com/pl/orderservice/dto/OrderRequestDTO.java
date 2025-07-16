package com.pl.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequestDTO(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity) {
}
