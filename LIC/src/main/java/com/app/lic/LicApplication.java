

package com.app.lic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class LicApplication {

	public static void main(String[] args) {
		System.out.println("Spring Boot Project");
		SpringApplication.run(LicApplication.class, args);
		System.out.println("Spring Boot Started.....");
	}

}
