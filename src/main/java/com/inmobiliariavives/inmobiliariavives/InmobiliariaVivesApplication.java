package com.inmobiliariavives.inmobiliariavives;

import com.inmobiliariavives.inmobiliariavives.repositories.EstateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class InmobiliariaVivesApplication {
	@Autowired
	private EstateRepository estateRepository;
	public static void main(String[] args) {
		SpringApplication.run(InmobiliariaVivesApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://vizainmobiliaria.com", "https://www.vizainmobiliaria.com")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

}
