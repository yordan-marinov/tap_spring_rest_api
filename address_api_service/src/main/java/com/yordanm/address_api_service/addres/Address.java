package com.yordanm.address_api_service.addres;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Address {

    @Id
    private UUID id;
    private String street_name;
    private int house_number;
    private String city;
}
