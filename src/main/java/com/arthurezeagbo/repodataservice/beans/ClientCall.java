package com.arthurezeagbo.repodataservice.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClientCall {

    @Bean
    public WebClient getWebClient(){
        return WebClient
                .builder()
                .build();
    }
}
