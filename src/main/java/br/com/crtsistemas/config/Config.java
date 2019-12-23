package br.com.crtsistemas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.crtsistemas.services.DBService;

@Configuration
public class Config {
	@Autowired
	private DBService dbService;

	@Bean
	public Boolean instantiateDatabase() {
		dbService.instantiateTestDatabase();
		return true;
	}
}
