package com.example.coffeeshop.application.controllers;

import com.example.coffeeshop.application.request.CreateOrderRequest;
import com.example.coffeeshop.application.response.CreateOrderResponse;
import com.example.coffeeshop.domain.services.OrderServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServicePort orderService;

    @Autowired
    public OrderController(OrderServicePort orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        final String id = orderService.createOrder(createOrderRequest.getProducts(), createOrderRequest.getTotalPrice());

        return new CreateOrderResponse(id);
    }
}
