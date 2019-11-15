package dev.alomari.service.provider.platform.core.order;

import dev.alomari.service.provider.platform.data.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderService {
    Order addOrder(Order order);

    Order viewOrder(Long orderId);

    Page<Order> listOrders(Pageable pageable);

    Order acceptOrder(Long orderId);

    Order rejectOrder(Long orderId);

    Order cancelOrder(Long orderId);

    Order closeOrder(Long orderId);
}
