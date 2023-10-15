package com.doggieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.doggieapi.models")
@EnableJpaRepositories(basePackages = "com.doggieapi.repositories")
public class DoggieapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoggieapiApplication.class, args);
	}

}
