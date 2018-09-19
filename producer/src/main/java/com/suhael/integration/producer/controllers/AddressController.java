package com.suhael.integration.producer.controllers;


import com.suhael.integration.producer.models.Address;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/address", produces = APPLICATION_JSON_VALUE)
public class AddressController {

    @GetMapping(value = "/{id}")
    public Address getAddress(@PathVariable int id) {
        Address address = new Address();
        address.setId(id);
        address.setBuilding("building");
        address.setStreet("street");
        return address;
    }


}
