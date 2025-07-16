package com.pl.orderservice.mapper;

import com.pl.orderservice.dto.OrderRequestDTO;
import com.pl.orderservice.model.OrderEntity;

public class OrderMapper {

    public static OrderEntity mapOrderRequestDtoToOrderEntity(OrderRequestDTO orderRequestDTO) {

        OrderEntity c = new OrderEntity();

        c.setQuantity(orderRequestDTO.quantity());
        c.setQuantity(orderRequestDTO.quantity());
        c.setQuantity(orderRequestDTO.quantity());

        return c;

    }
}
