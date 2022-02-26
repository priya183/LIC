package com.userRoleProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.userRoleProject.entity.Role;

public interface  RoleRepository extends CrudRepository<Role , Integer> {

	public Role findByRoleNameAndRoleDescription(String roleName,String roleDescription);
	public Role findByRoleId(Integer roleId);
}
