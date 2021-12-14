package com.yoranm.user_api_service.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class TransactionModel {

    @Id
    private UUID id;
    private int amount;
}
