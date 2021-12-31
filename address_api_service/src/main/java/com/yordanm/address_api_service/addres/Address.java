package com.yordanm.address_api_service.addres;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private UUID userId;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private Integer houseNumber;
    @Column(nullable = false)
    private String city;
}
