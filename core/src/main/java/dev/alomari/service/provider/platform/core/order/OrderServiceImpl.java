package dev.alomari.service.provider.platform.core.order;

import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.address.AddressRepository;
import dev.alomari.service.provider.platform.data.order.Order;
import dev.alomari.service.provider.platform.data.order.OrderRepository;
import dev.alomari.service.provider.platform.data.order.OrderStatus;
import dev.alomari.service.provider.platform.data.order.listing.ListingRepository;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.utility.constants.Authorities;
import dev.alomari.service.provider.platform.utility.constants.Profiles;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import dev.alomari.service.provider.platform.utility.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@Profile({Profiles.DEVELOPMENT, Profiles.PRODUCTION})
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, AddressRepository addressRepository, ListingRepository listingRepository) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.listingRepository = listingRepository;
    }

    @Override
    @Transactional
    public Order addOrder(Order order) {
        User user = SecurityUtil.getCurrentUser();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);

        if(order.getAddress().getId() == null) {
            throw new ServiceProviderException(ServiceProviderError.INVALID_DATA_INPUT);
        }

        Address address = addressRepository.findById(order.getAddress().getId()).orElseThrow(
                () -> new ServiceProviderException(ServiceProviderError.NO_DATA_FOUND)
        );

        order.setAddress(address);

        order.getListings().forEach(listing -> listing.setOrder(order));

        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Order> listOrders(Pageable pageable) {
        User currentUser = SecurityUtil.getCurrentUser();

        if(SecurityUtil.hasAuthority(Authorities.ORDERS_LIST_ALL.getAuthority())) {
            return orderRepository.findAll(pageable);
        } else {
            return orderRepository.findAllByUser(currentUser, pageable);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Order viewOrder(Long orderId) {
        Order order = getOrderById(orderId);

        // If user does not have the ability to access information, don't allow them to view it
        SecurityUtil.validateAbilityToAccessInformation(order.getUser(), Authorities.ORDERS_VIEW_ALL.getAuthority());

        return order;
    }

    @Transactional
    @Override
    public Order acceptOrder(Long orderId) {
        Order order = getOrderById(orderId);

        return updateOrderStatus(order, OrderStatus.ACCEPTED);
    }

    @Transactional
    @Override
    public Order rejectOrder(Long orderId) {
        Order order = getOrderById(orderId);

        return updateOrderStatus(order, OrderStatus.REJECTED);
    }

    @Transactional
    @Override
    public Order cancelOrder(Long orderId) {
        Order order = getOrderById(orderId);

        if(!SecurityUtil.validateAbilityToAccessInformation(order.getUser(), null)) {
            throw new ServiceProviderException(ServiceProviderError.NOT_OWNER_OF_INFO);
        }

        return updateOrderStatus(order, OrderStatus.CANCELED);
    }


    @Override
    public Order closeOrder(Long orderId) {
        Order order = getOrderById(orderId);

        return updateOrderStatus(order, OrderStatus.CLOSED);
    }


    /* ----[ Helper Methods ]---- */
    /*                            */
    private Order updateOrderStatus(Order order, OrderStatus newStatus) {

        // If order status is not pending do not allow to change it
        if(!order.getStatus().equals(OrderStatus.PENDING)) {
            throw new ServiceProviderException(ServiceProviderError.ORDER_IS_ALREADY_UPDATED);
        }

        order.setStatus(newStatus);

        orderRepository.save(order);

        return order;
    }

    private Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
                () -> new ServiceProviderException(ServiceProviderError.NO_DATA_FOUND)
        );
    }

}
