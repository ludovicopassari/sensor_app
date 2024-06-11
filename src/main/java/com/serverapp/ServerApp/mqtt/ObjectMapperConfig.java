package com.serverapp.ServerApp.mqtt;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonParserConfig {

    @Bean
    public ObjectMapper jsonObjectMapper() {
        return new ObjectMapper();
    }


}