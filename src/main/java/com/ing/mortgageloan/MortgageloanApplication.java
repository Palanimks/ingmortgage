package com.ing.mortgageloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MortgageloanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageloanApplication.class, args);
	}

}
