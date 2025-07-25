package com.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mk.entity")
public class TaskManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementBackendApplication.class, args);
	}

}
