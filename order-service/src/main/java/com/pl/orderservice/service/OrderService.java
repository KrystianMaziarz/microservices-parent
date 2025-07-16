package com.pl.orderservice.service;

import com.pl.orderservice.dto.OrderRequestDTO;
import com.pl.orderservice.model.OrderEntity;
import com.pl.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequestDTO orderRequestDTO) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(UUID.randomUUID().toString());
        orderEntity.setSkuCode(orderRequestDTO.skuCode());
        orderEntity.setPrice(orderRequestDTO.price());
        orderEntity.setQuantity(orderRequestDTO.quantity());
        orderRepository.save(orderEntity);
    }
}
