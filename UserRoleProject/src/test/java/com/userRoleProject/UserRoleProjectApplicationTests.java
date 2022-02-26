package com.userRoleProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.userRoleProject.repository.UserRoleRepository;

@SpringBootTest
class UserRoleProjectApplicationTests {

	//@Test
	void contextLoads() {
	}
	@Autowired
	UserRoleRepository userRoleRepository;
	
	//@Test
	public  void testFindById() {
		System.out.println(userRoleRepository.findById(1));
	
		
	}
	
}
