package com.pl.orderservice.controller;

import com.pl.orderservice.dto.OrderRequestDTO;
import com.pl.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {

        orderService.placeOrder(orderRequestDTO);

        return "Order Placed successfully";
    }

}
