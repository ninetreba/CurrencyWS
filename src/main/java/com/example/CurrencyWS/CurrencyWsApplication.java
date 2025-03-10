package com.example.CurrencyWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CurrencyWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyWsApplication.class, args);
	}

}
