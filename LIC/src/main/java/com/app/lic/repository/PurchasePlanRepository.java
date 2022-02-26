package com.app.lic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.lic.model.PurchasePlan;

public interface PurchasePlanRepository extends CrudRepository<PurchasePlan, Long> {
	public PurchasePlan findByPurchasePlanId(Long purchasePlanId);
	
	List<PurchasePlan> findAll();
	
}
