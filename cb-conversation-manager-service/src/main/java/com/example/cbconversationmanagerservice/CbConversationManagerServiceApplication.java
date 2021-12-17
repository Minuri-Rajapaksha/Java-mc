package com.example.cbconversationmanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Conversation Manager Service API", version = "2.0", description = "Conversation Manager Service Information"))
public class CbConversationManagerServiceApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder(); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CbConversationManagerServiceApplication.class, args);
	}

}
