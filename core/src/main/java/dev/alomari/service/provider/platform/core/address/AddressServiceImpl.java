package dev.alomari.service.provider.platform.core.address;

import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.address.AddressRepository;
import dev.alomari.service.provider.platform.data.address.AddressStatus;
import dev.alomari.service.provider.platform.data.security.user.User;
import dev.alomari.service.provider.platform.utility.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addAddress(Address address) {
        User user = SecurityUtil.getCurrentUser();

        address.setUser(user);
        address.setStatus(AddressStatus.ACTIVE);
        address.setCreatedBy(String.valueOf(user.getId()));

        return addressRepository.save(address);
    }
}
