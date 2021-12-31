package com.yordanm.address_api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class AddressApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApiServiceApplication.class, args);
    }

}
