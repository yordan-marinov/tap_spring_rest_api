package com.yoranm.user_api_service.models;


import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class IdModelUser {


    private UUID uuid;
    private Instant time;
}
