package com.yoranm.user_api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableMongoRepositories
public class UserApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiServiceApplication.class, args);
    }
}
