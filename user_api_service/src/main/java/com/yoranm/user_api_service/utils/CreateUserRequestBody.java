package com.yoranm.user_api_service.utils;

import com.yoranm.user_api_service.dto.AddressDTO;
import com.yoranm.user_api_service.dto.TransactionDTO;
import com.yoranm.user_api_service.model.User;
import lombok.Data;

@Data
public class CreateUserRequestBody {
    User user;
    AddressDTO address;
    TransactionDTO transaction;
}
