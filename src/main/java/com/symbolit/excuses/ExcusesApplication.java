package com.symbolit.excuses;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.symbolit.excuses.api.v1.service.ExcuseService;
import com.symbolit.excuses.api.v1.model.transit.ExcuseDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class ExcusesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcusesApplication.class, args);
	}
	
	@Bean 
	CommandLineRunner  runner(ExcuseService excuseService)  {
		return args -> {
			ObjectMapper objectMapper  = new ObjectMapper();
			TypeReference<List<ExcuseDTO>> typeReference  = new TypeReference <List<ExcuseDTO>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/excuses.json");
			
			try {
				List<ExcuseDTO> excuses = objectMapper.readValue(inputStream, typeReference);
				excuseService.saveAll(excuses);
				System.err.println("Exuses saved successfully");

			} catch(IOException e) {
				System.err.println(String.format("Unable to save excuses: %s", e.getMessage()));
			}
			
	};
	}
}
