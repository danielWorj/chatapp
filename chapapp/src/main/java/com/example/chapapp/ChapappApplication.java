package com.example.chapapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChapappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChapappApplication.class, args);
	}

}
