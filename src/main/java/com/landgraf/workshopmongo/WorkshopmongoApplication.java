package com.landgraf.workshopmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mongodb.autoconfigure.MongoAutoConfiguration;

@SpringBootApplication
public class WorkshopmongoApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongoApplication.class, args);
	}
}
