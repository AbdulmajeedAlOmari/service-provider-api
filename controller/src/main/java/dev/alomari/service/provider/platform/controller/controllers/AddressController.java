package dev.alomari.service.provider.platform.controller.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import dev.alomari.service.provider.platform.core.address.AddressService;
import dev.alomari.service.provider.platform.data.address.Address;
import dev.alomari.service.provider.platform.data.common.jsonviews.View;
import dev.alomari.service.provider.platform.data.common.validation.groups.Validation;
import dev.alomari.service.provider.platform.utility.constants.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.ADDRESS_ROUTE_V1)
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PreAuthorize("hasAuthority('')")
    @PostMapping
    @JsonView({ View.SimpleView.class })
    public ResponseEntity<Address> addAddress(@Validated(Validation.Input.class) @RequestBody Address address) {
        return ResponseEntity.ok(addressService.addAddress(address));
    }
}
