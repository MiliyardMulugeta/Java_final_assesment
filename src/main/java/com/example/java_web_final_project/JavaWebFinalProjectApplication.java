package com.example.java_web_final_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JavaWebFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaWebFinalProjectApplication.class, args);
	}

}
