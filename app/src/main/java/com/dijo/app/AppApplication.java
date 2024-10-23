package com.dijo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.dijo.app")
@EntityScan("com.dijo.app")
@SpringBootApplication
public class AppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
