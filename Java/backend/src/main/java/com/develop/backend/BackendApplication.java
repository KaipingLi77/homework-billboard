package com.develop.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = {"com.develop.backend.Controller","com.develop.backend"})
//@ComponentScan({"com.develop.backend","com.develop.backend.Controller","com.develop.backend.Model", "com.develop.backend.repository", "com.develop.backend.service"})
@EntityScan({"com.develop.backend","com.develop.backend.Controller","com.develop.backend.Model", "com.develop.backend.repository", "com.develop.backend.service"})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
