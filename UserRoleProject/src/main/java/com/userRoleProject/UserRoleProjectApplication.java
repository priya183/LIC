package com.userRoleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
public class UserRoleProjectApplication {

	public static void main(String[] args) {
		System.out.println("Starting project.....");
		SpringApplication.run(UserRoleProjectApplication.class, args);
		System.out.println("UserRole Project Started.....");
	}

}
