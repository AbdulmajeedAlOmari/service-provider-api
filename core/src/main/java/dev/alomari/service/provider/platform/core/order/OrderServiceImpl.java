package dev.alomari.service.provider.platform.core.order;

import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.data.order.OrderRepository;
import dev.alomari.service.provider.platform.data.order.OrderStatus;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.utility.constants.Profiles;
import dev.alomari.service.provider.platform.utility.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({Profiles.DEVELOPMENT, Profiles.PRODUCTION})
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        User user = SecurityUtil.getCurrentUser();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);

        return orderRepository.save(order);
    }
}
