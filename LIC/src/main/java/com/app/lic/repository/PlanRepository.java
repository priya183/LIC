package com.app.lic.repository;

import org.springframework.data.repository.CrudRepository;


import com.app.lic.model.Plan;

public interface PlanRepository extends CrudRepository<Plan, String>{
	
	public Plan findByName(String name);
	public Plan findByPanId(Long long1);
	public Plan findByPanId(Plan long1);
	

}
