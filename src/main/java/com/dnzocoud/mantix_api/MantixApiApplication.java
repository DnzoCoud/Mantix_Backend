package com.dnzocoud.mantix_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.dnzocoud.mantix_api.infrastructure.entities")
@EnableJpaRepositories(basePackages = "com.dnzocoud.mantix_api.infrastructure.persistence")
public class MantixApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MantixApiApplication.class, args);
	}
}
