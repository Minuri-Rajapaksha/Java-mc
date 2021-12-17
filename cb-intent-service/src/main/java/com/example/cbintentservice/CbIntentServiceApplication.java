package com.example.cbintentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Intent Service API", version = "2.0", description = "Intent Service Information"))
public class CbIntentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbIntentServiceApplication.class, args);
	}

}
