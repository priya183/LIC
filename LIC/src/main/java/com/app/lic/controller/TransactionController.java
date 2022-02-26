package com.app.lic.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.lic.dto.TransactionDto;
import com.app.lic.dto.TransactionResponse;
import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;
import com.app.lic.model.Transaction;
import com.app.lic.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
  TransactionService transactionService;

	
	@PostMapping("/addTransaction")
	public ResponseEntity<TransactionResponse> addTransaction(@Validated  @RequestBody  TransactionDto transactionDto) {
		
		System.out.println(transactionDto);

		TransactionResponse transactionRes = transactionService.addTransaction(transactionDto);
		ResponseEntity<TransactionResponse> res = null;

		try {
			res = new ResponseEntity<TransactionResponse>(transactionRes, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<TransactionResponse>(transactionRes, HttpStatus.NOT_FOUND);

		}
return res;
	}

	/*
	 * @GetMapping("/showAllTransaction")
	 public ResponseEntity<TransactionResponse> showAllUser(@Validated  @RequestBody  TransactionDto transactionDto) {
		
		System.out.println(userDto);

		UserResponse userRes = userService.updateUser(userDto);
		ResponseEntity<UserResponse> res = null;

		try {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.NOT_FOUND);

		}
return res;
	}*/
	
	
	
/*@GetMapping("/showDetail/{panId}/{appUserId}")
	public ResponseEntity<TransactionResponse> showDetail(@PathVariable Long panId,@PathVariable Long appUserId) {
		
		

		TransactionResponse transactionRes = transactionService.showDetails( panId,appUserId);
		ResponseEntity<TransactionResponse> res = null;

		try {
			res = new ResponseEntity<TransactionResponse>(transactionRes, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<TransactionResponse>(transactionRes, HttpStatus.NOT_FOUND);

		}
return res;
}*/

}

