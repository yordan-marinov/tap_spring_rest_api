package com.yoranm.user_api_service.dto;


import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

//    private UUID userId;
    private String streetName;
    private Integer houseNumber;
    private String city;
}

