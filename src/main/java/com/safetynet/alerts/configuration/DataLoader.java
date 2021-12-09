package com.safetynet.alerts.configuration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.ArrayContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class DataLoader {
    @Value("classpath:data/data.json")
    Resource resourceFile;

    @Bean
    public ArrayContainer data() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayContainer arrayContainer = objectMapper.readValue(resourceFile.getFile(), ArrayContainer.class);
        System.out.println(arrayContainer);
        return arrayContainer;
    }
}
