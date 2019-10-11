package dev.alomari.service.provider.platform.core.order;

import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.data.order.OrderRepository;
import dev.alomari.service.provider.platform.utility.constants.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Profile({ Profiles.MOCK })
public class OrderServiceMock implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceMock(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        order.setId(3134L);
        return order;
    }

    @Override
    public Page<Order> listOrders(Pageable pageable) {
        return null;
    }

    @Override
    public Order viewOrder(Long orderId) {
        return null;
    }
}
