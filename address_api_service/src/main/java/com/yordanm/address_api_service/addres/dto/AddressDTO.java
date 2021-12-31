package com.yordanm.address_api_service.addres.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDTO {

    private UUID userId;
    private String streetName;
    private Integer houseNumber;
    private String city;
}
