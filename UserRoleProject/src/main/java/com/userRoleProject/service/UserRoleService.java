package com.userRoleProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRoleProject.entity.UserRole;
import com.userRoleProject.repository.UserRoleRepository;

@Service
public class UserRoleService {
	
	@Autowired
	UserRoleRepository userRoleRepo;
	
	 public UserRole getId(Integer user_role_id)
	 {
	  UserRole ur=userRoleRepo.findByUserRoleId(user_role_id);
	  return ur;
	  }
}

