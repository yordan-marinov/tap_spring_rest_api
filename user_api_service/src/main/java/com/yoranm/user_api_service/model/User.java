package com.yoranm.user_api_service.model;


import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private final UUID uuid = UUID.randomUUID();
    private String firstName;
    private String lastName;
}
