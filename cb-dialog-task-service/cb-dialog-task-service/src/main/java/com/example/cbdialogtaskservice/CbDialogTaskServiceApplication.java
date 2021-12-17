package com.example.cbdialogtaskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Dialog Service API", version = "2.0", description = "Dialog Service Information"))
public class CbDialogTaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbDialogTaskServiceApplication.class, args);
	}

}
