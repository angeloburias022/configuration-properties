package com.springboot.configuration_properties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class BasicConfig {
    private String appName;

    @PostConstruct
    public void init() {
        log.info("[TRACE] app name {}", appName);
    }    
}
