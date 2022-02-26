package com.userRoleProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRoleProject.entity.UserRole;
import com.userRoleProject.repository.RoleRepository;


@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepo;

	public UserRole getRole(Integer userId) {
		return null;
	}
}