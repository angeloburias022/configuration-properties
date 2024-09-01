package com.springboot.configuration_properties.service;

import org.springframework.stereotype.Service;

import com.springboot.configuration_properties.config.ApiConfig;
import com.springboot.configuration_properties.config.ApiConfig.ClientConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final ApiConfig apiConfig;

     public void performApiCall() {
        // Access Google API client configuration
        ClientConfig googleConfig = apiConfig.getClients().get("google");
        System.out.println("Google API Base URL: " + googleConfig.getBaseUrl());
        System.out.println("Google API Key: " + googleConfig.getApiKey());
        System.out.println("Google API Timeout: " + googleConfig.getTimeout());

        // Access GitHub API client configuration
        ClientConfig githubConfig = apiConfig.getClients().get("github");
        System.out.println("GitHub API Base URL: " + githubConfig.getBaseUrl());
        System.out.println("GitHub API Key: " + githubConfig.getApiKey());
        System.out.println("GitHub API Timeout: " + githubConfig.getTimeout());

        // Here, you can use these configurations to set up and make requests to the respective APIs.
    }
}
