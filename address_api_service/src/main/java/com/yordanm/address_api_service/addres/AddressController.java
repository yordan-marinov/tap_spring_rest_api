package com.yordanm.address_api_service.addres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AddressController {


    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/api/resources/users/{id}/addresses")
    private List<Address> getUserAddresses(@PathVariable UUID id){
        return addressService.getAll(id);
    }

    @PostMapping("/api/resources/addresses")
    private void addNewAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }

    @PutMapping("/api/resources/users/{userid}/addresses/{id}")
    private void updateAddresses(@RequestBody Address address){
        addressService.update(address);
    }

    @DeleteMapping("/api/resources/users/{userid}/addresses/{id}")
    private void deleteAddresses(@PathVariable Long id){
        addressService.delete(id);
    }

}
