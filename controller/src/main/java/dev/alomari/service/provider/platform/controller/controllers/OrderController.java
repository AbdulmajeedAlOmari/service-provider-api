package dev.alomari.service.provider.platform.controller.controllers;

import dev.alomari.service.provider.platform.core.order.OrderService;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.ORDER_ROUTE_V1)
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @GetMapping
    public ResponseEntity<Order> listOrders(Order order) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> viewOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PutMapping("/{orderId}/accept")
    public ResponseEntity<Order> acceptOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PutMapping("/{orderId}/reject")
    public ResponseEntity<Order> rejectOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PutMapping("/{orderId}/close")
    public ResponseEntity<Order> closeOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }
}
