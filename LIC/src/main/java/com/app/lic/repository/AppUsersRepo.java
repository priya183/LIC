package com.app.lic.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.lic.model.AppUsers;

public interface AppUsersRepo extends CrudRepository<AppUsers, Long> {

	// select * from app_usersn where AdharNo
	public AppUsers findByAdharNo(String adharNo);

	public AppUsers findByAppUserId(Long appUserId);
	public AppUsers findByAppUserId(AppUsers appUserId);
}
