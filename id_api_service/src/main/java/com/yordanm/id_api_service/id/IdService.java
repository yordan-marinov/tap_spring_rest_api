package com.yordanm.id_api_service.id;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class IdService {
    public HashMap<String, String> getCurrentId() {
        IdModel model = new IdModel();
        String id = model.getUuid().toString();
        System.out.println(id);
        String time = model.getTime().toString();

        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", id);
        map.put("time", time);

        return map;
    }
}
