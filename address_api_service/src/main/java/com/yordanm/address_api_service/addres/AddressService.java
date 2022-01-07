package com.yordanm.address_api_service.addres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public List<Address> getAll(UUID userId) {
        return addressRepository.findAllByUserId(userId);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public void update(Address address) {
        addressRepository.save(address);
    }
}
