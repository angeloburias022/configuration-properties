package com.springboot.configuration_properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.configuration_properties.config.ApiConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ConfigurationPropertiesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
    private ApiConfig apiConfig;

 	@Test
	public void testApiConfig() {
		log.info("[TRACE] Starting API configuration test...");

		// Verify Google API client configuration
		ApiConfig.ClientConfig googleConfig = apiConfig.getClients().get("google");
		assertNotNull(googleConfig, "Google API configuration should not be null");
		log.info("[TRACE] Google API Config: Base URL = {}, API Key = {}, Timeout = {}",
				googleConfig.getBaseUrl(), googleConfig.getApiKey(), googleConfig.getTimeout());
		assertEquals("https://www.googleapis.com", googleConfig.getBaseUrl(), "Google API base URL should match");
		assertEquals("your-google-api-key", googleConfig.getApiKey(), "Google API key should match");
		assertEquals(5000, googleConfig.getTimeout(), "Google API timeout should match");

		// Verify GitHub API client configuration
		ApiConfig.ClientConfig githubConfig = apiConfig.getClients().get("github");
		assertNotNull(githubConfig, "GitHub API configuration should not be null");
		log.info("[TRACE] GitHub API Config: Base URL = {}, API Key = {}, Timeout = {}",
				githubConfig.getBaseUrl(), githubConfig.getApiKey(), githubConfig.getTimeout());
		assertEquals("https://api.github.com", githubConfig.getBaseUrl(), "GitHub API base URL should match");
		assertEquals("your-github-api-key", githubConfig.getApiKey(), "GitHub API key should match");
		assertEquals(3000, githubConfig.getTimeout(), "GitHub API timeout should match");
	}
}
