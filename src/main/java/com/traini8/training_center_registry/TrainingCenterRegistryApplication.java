package com.traini8.training_center_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.traini8.training_center_registry")
public class TrainingCenterRegistryApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrainingCenterRegistryApplication.class, args);
	}

}
