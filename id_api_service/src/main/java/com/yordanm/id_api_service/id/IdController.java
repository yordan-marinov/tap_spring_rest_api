package com.yordanm.id_api_service.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IdController {

    private final IdService idService;

    @Autowired
    public IdController(IdService idService) {
        this.idService = idService;
    }

    @GetMapping("/api/resources/id")
    public HashMap<String, String> getId() {
        return idService.getCurrentId();
    }

}
