package com.springboot.configuration_properties.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix ="api")
public class ApiConfig {
    private Map<String, ClientConfig> clients;

    @Data
    public static class ClientConfig {
        private String baseUrl;
        private String apiKey;
        private int timeout;
    }
    
}
