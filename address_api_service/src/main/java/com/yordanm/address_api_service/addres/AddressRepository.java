package com.yordanm.address_api_service.addres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByUserId(UUID userId);
}
