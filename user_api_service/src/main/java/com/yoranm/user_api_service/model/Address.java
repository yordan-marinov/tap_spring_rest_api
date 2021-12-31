package com.yoranm.user_api_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Address {

    private UUID userId;
    private String streetName;
    private Integer houseNumber;
    private String city;
}
