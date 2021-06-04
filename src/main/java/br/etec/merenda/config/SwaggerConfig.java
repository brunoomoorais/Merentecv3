package br.etec.merenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI merendaOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("API do Projeto Merentec da FATEC")
				);
	}
}
