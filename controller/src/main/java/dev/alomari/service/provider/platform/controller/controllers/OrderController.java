package dev.alomari.service.provider.platform.controller.controllers;

import dev.alomari.service.provider.platform.core.order.OrderService;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.ORDER_ROUTE_V1)
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public ResponseEntity<Order> newOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.newOrder(order));
    }
}
