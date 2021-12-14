package com.yordanm.address_api_service.addres;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getOneByID(Long id) throws ChangeSetPersister.NotFoundException {
        return addressRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

    }

    public void updateAddress(Address newAddress, Long id) {
        addressRepository.findById(id)
                .map(address -> {
                    address.setStreet_name(newAddress.getStreet_name());
                    address.setHouse_number(newAddress.getHouse_number());
                    address.setCity(newAddress.getCity());
                    return addressRepository.save(address);
                })
                .orElseGet(() -> {
                    newAddress.setId(id);
                    return addressRepository.save(newAddress);
                });

    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
