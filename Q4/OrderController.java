package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.example.demo.client.PaymentGatewayClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final PaymentGatewayClient gateway;

    public OrderController(OrderService service, PaymentGatewayClient gateway) {
        this.service = service;
        this.gateway = gateway;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        gateway.charge();
        return service.createOrder(order);
    }
}
