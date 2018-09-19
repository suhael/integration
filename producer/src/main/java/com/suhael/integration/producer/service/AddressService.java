package com.suhael.integration.producer.service;


import com.suhael.integration.producer.models.Address;
import com.suhael.integration.producer.repository.AddressRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public void saveAddress(Address address) {
        repository.save(address);
    }

    public Optional<Address> getAddressById(int id) {
        return repository.findById(id);
    }
}
