package com.userRoleProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.userRoleProject.entity.User;

public interface UserRepository extends JpaRepository<User , Integer> {
	
public	User findByEmailAndPassword(String email, String password);

}
