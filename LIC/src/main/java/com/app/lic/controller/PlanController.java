package com.app.lic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.lic.dto.PlanDto;
import com.app.lic.dto.PlanResponse;

import com.app.lic.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	PlanService planService;

	
	@PostMapping("/addPlan")
	public ResponseEntity<PlanResponse> addPlan(@Validated  @RequestBody  PlanDto planDto) {
		
		System.out.println(planDto);

		PlanResponse planRes = planService.addPlan(planDto);
		ResponseEntity<PlanResponse> res = null;

		try {
			res = new ResponseEntity<PlanResponse>(planRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<PlanResponse>(planRes, HttpStatus.NOT_FOUND);

		}
return res;
	}

	
	@PostMapping("/updatePlan")
	public ResponseEntity<PlanResponse> updateUser(@Validated  @RequestBody  PlanDto planDto) {
		
		System.out.println(planDto);

		PlanResponse planRes = planService.updateUser(planDto);
		ResponseEntity<PlanResponse> res = null;

		try {
			res = new ResponseEntity<PlanResponse>(planRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<PlanResponse>(planRes, HttpStatus.NOT_FOUND);

		}
return res;
	}
	
	
	//could not execute statement; SQL [n/a]; constraint [null]; nested exception is
	//org.hibernate.exception.ConstraintViolationException: could not execute statement
	@GetMapping("deletePlan/{name}")
	public ResponseEntity<PlanResponse> deleteUser(@PathVariable("name")  String name) {
		
		

		PlanResponse planRes = planService.deleteUser(name);
		ResponseEntity<PlanResponse> res = null;

		try {
			res = new ResponseEntity<PlanResponse>(planRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<PlanResponse>(planRes, HttpStatus.NOT_FOUND);

		}
return res;
	}
}

	


