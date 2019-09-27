package dev.alomari.service.provider.platform.core.order;

import dev.alomari.service.provider.platform.data.order.Order;
import org.springframework.stereotype.Service;

public interface OrderService {
    Order addOrder(Order order);
}
