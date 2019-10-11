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
        User currentUser = SecurityUtil.getCurrentUser();

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ServiceProviderException(ServiceProviderError.NO_DATA_FOUND)
        );

        // If user have authority to view any user's order, let them see the order without checking for owner
        if(SecurityUtil.hasAuthority(Authorities.ORDERS_VIEW_ALL.getAuthority())) {
            return order;
        }

        if(!currentUser.getId().equals(order.getUser().getId())) {
            throw new ServiceProviderException(ServiceProviderError.NOT_OWNER_OF_INFO);
        }

        return order;
    }
}
