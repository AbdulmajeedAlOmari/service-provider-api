package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.address.AddressService;
import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderError;
import dev.alomari.service.provider.platform.utility.exceptions.ServiceProviderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping(Routes.ADDRESS_ROUTE_V1)
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PreAuthorize("hasAuthority('ADDRESSES:ADD')")
    @PostMapping
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Address> addAddress(@Validated(Validation.Input.class) @RequestBody Address address) {
        return ResponseEntity.ok(addressService.addAddress(address));
    }

    // TODO: Change privilege
    @PreAuthorize("hasAuthority('ADDRESSES:ADD')")
    @GetMapping
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Address> listAddresses(@PageableDefault Pageable pageable) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    // TODO: Change privilege
    @PreAuthorize("hasAuthority('ADDRESSES:ADD')")
    @GetMapping("/{id}")
    @JsonView({ View.DetailedView.class })
    public ResponseEntity<Address> viewAddress(@Validated(Validation.Input.class) @RequestBody Address address) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    // TODO: Change privilege
    @PreAuthorize("hasAuthority('ADDRESSES:ADD')")
    @PutMapping("/{id}")
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Address> updateAddress(@Validated(Validation.Input.class) @RequestBody Address address) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }

    // TODO: Change privilege
    @PreAuthorize("hasAuthority('ADDRESSES:ADD')")
    @DeleteMapping("/{id}")
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Address> deleteAddress(@Validated(Validation.Input.class) @RequestBody Address address) {
        throw new ServiceProviderException(ServiceProviderError.NOT_IMPLEMENTED);
    }
}
