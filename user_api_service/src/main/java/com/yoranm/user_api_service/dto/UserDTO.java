package com.yoranm.user_api_service.dto;


import com.yoranm.user_api_service.models.AddressModel;
import com.yoranm.user_api_service.models.TransactionModel;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String firstName;
    private String lastName;
    private List<AddressModel> addresses;
    private List<TransactionModel> transactions;

}
