package com.yordanm.id_api_service.id;


import java.time.Instant;
import java.util.UUID;


public class IdModel {

    private final UUID uuid = UUID.randomUUID();
    private final Instant time = Instant.now();


    public UUID getUuid() {
        return uuid;
    }

    public Instant getTime() {
        return time;
    }
}
