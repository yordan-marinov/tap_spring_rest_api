package com.yoranm.user_api_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Transaction {

    private UUID userId;
    private int amount;
}
