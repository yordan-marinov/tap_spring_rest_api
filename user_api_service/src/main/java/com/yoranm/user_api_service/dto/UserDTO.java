package com.yoranm.user_api_service.dto;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {

    private UUID userId;
    private String firstName;
    private String lastName;
    private List<AddressDTO> addresses;
    private List<TransactionDTO> transactions;
}
