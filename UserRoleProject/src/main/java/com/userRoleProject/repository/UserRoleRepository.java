package com.userRoleProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.userRoleProject.entity.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole,Integer> {
	
	
	@Query( value=" Select * from user_role u where u.user_role_id=?1",
			 nativeQuery = true)
	public UserRole findByUserRoleId(Integer userId);

}
