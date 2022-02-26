package com.userRoleProject.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRoleProject.entity.User;
import com.userRoleProject.entity.UserRole;
import com.userRoleProject.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	List<User> user=new ArrayList<>();
	public User login(String email,String password)
	
	{ 
		User user = userRepo.findByEmailAndPassword(email, password);
		
	
		if (Objects.nonNull(user)) {
	
		
		System.out.println("Email="+user.getEmail());
		}
		return user;
		
	}
	
	public List<User> getAllUser()
	{
		userRepo.findAll().forEach(user::add);
		return user;
	}

	public UserRole getId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRole getId1(Integer userId) {
		UserRole u=(UserRole) userRepo.findAll();
		return u;
	}
	
}
