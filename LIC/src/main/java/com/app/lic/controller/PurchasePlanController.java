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

import com.app.lic.dto.PurchasePlanDto;
import com.app.lic.dto.PurchasePlanResponse;
import com.app.lic.service.PurchasePlanService;

@RestController
public class PurchasePlanController {

	@Autowired
	PurchasePlanService purchasePlanService;

	@PostMapping("/addPurchasePlan")
	public ResponseEntity<PurchasePlanResponse> addPurchasePlan(
			@Validated @RequestBody PurchasePlanDto purchasePlanDto) {

		System.out.println(purchasePlanDto);

		PurchasePlanResponse purchasePlanRes = purchasePlanService.addPurchasePlan(purchasePlanDto);
		ResponseEntity<PurchasePlanResponse> res = null;

		try {
			res = new ResponseEntity<PurchasePlanResponse>(purchasePlanRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<PurchasePlanResponse>(purchasePlanRes, HttpStatus.NOT_FOUND);

		}
		return res;
	}

	@GetMapping("/showAllPlanPurchase")
	public ResponseEntity<PurchasePlanResponse> showAllPurchasePlan(PurchasePlanDto purchasePlanDto) {

		PurchasePlanResponse PurchasePlanRes = purchasePlanService.showAllPurchasePlan(purchasePlanDto);
		ResponseEntity<PurchasePlanResponse> res = null;

		try {
			res = new ResponseEntity<PurchasePlanResponse>(PurchasePlanRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<PurchasePlanResponse>(PurchasePlanRes, HttpStatus.NOT_FOUND);

		}
		return res;
	}

	@GetMapping("showPurchasePlanById/{purchasePlanId}")
	public ResponseEntity<PurchasePlanResponse> showById(@PathVariable("purchasePlanId") Long purchasePlanId) {

		PurchasePlanResponse purchasePlanRes = purchasePlanService.showPurchasePlanById(purchasePlanId);
		ResponseEntity<PurchasePlanResponse> res = null;

		try {
			res = new ResponseEntity<PurchasePlanResponse>(purchasePlanRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<PurchasePlanResponse>(purchasePlanRes, HttpStatus.NOT_FOUND);

		}
		return res;
	}

}
