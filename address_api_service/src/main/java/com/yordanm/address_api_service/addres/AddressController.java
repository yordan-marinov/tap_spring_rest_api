package com.yordanm.address_api_service.addres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {


    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/api/resource/addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAll();
    }

    @GetMapping("api/resource/address/{id}")
    public Address getOneAddress(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return addressService.getOneByID(id);
    }

    @PostMapping("api/resource/address")
    public void addNewAddress(@RequestBody Address address){
        addressService.addAddress(address);

    }

    @PutMapping("api/resource/address/{id}")
    public void updateAddressByID(@RequestBody Address newAddress, @PathVariable Long id){
        addressService.updateAddress(newAddress, id);
    }

    @DeleteMapping("api/resource/address/{id}")
    public void deleteAddressByID(@PathVariable Long id){
        addressService.deleteAddress(id);
    }


}
