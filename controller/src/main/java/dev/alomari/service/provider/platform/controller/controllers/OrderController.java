package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.order.OrderService;
import dev.alomari.service.provider.platform.data.common.jsonviews.List;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.ORDER_ROUTE_V1)
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PreAuthorize("hasAuthority('ORDERS:ADD')")
    @PostMapping
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Order> addOrder(@Validated(Validation.Input.class) @RequestBody Order order) {
        return ResponseEntity.ok(orderService.addOrder(order));
    }

    @PreAuthorize("hasAuthority('ORDERS:LIST')")
    @GetMapping
    @JsonView({ List.SimpleList.class })
    public ResponseEntity<Page<Order>> listOrders(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(orderService.listOrders(pageable));
    }

    @PreAuthorize("hasAuthority('ORDERS:VIEW')")
    @GetMapping("/{orderId}")
    @JsonView({ View.DetailedView.class })
    public ResponseEntity<Order> viewOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.viewOrder(orderId));
    }

    @PreAuthorize("hasAuthority('ORDERS:REPLY_ALL')")
    @PutMapping("/{orderId}/accept")
    public ResponseEntity<Order> acceptOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasAuthority('ORDERS:REPLY_ALL')")
    @PutMapping("/{orderId}/reject")
    public ResponseEntity<Order> rejectOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasAuthority('ORDERS:CANCEL')")
    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasAuthority('ORDERS:CLOSE_ALL')")
    @PutMapping("/{orderId}/close")
    public ResponseEntity<Order> closeOrder(@PathVariable Long orderId) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }
}
