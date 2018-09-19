package com.suhael.integration.consumer.controllers;

import com.suhael.integration.consumer.models.Address;
import com.suhael.integration.consumer.service.AddressService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/address", produces = APPLICATION_JSON_VALUE)
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public Optional<Address> getAddress(@PathVariable int id) {
        return service.getAddressById(id);
    }

    @GetMapping
    public List<Address> getAllAddressess() {
        return service.getAllAddresses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAddress(@RequestBody Address address) {
        service.saveAddress(address);
    }

}
