package com.yoranm.user_api_service.configurarations;

import com.yoranm.user_api_service.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class Beans {
    @Bean
    public WebClient webClient() {
        return WebClient.create(Constants.GENERATE_ID_URI);
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}