package com.yoranm.user_api_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

//    private UUID userId;
    private int amount;
}
