package com.example.UMC_6week;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc6weekApplication {

	public static void main(String[] args) {

		SpringApplication.run(Umc6weekApplication.class, args);
	}

}
