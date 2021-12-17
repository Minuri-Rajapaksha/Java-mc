package com.example.gradlesamplewitheureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GradleSampleWithEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleSampleWithEurekaApplication.class, args);
	}

}
