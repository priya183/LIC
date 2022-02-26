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

import com.app.lic.dto.UserDto;
import com.app.lic.dto.UserResponse;
import com.app.lic.model.AppUsers;
import com.app.lic.service.UsersService;
import com.app.lic.repository.*;
@RestController
public class UsersController {

	@Autowired
	UsersService userService;
   @Autowired
   AppUsersRepo appUsersRepo;
   
	
	@PostMapping("/addUser")
	public ResponseEntity<UserResponse> addUser(@Validated  @RequestBody  UserDto userDto) {
		
		System.out.println(userDto);

		UserResponse userRes = userService.addUser(userDto);
		ResponseEntity<UserResponse> res = null;

		try {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.NOT_FOUND);

		}
return res;
	}

	
	@PostMapping("/updateUser")
	public ResponseEntity<UserResponse> updateUser(@Validated  @RequestBody  UserDto userDto) {
		
		System.out.println(userDto);

		UserResponse userRes = userService.updateUser(userDto);
		ResponseEntity<UserResponse> res = null;

		try {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.NOT_FOUND);

		}
return res;
	}
	
	
	
	@GetMapping("deleteUser/{adharNo}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable("adharNo")  String adharCard) {
		
		

		UserResponse userRes = userService.deleteUser(adharCard);
		ResponseEntity<UserResponse> res = null;

		try {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<UserResponse>(userRes, HttpStatus.NOT_FOUND);

		}
return res;
	}
	@GetMapping("/showAllUser")
public ResponseEntity<List<UserResponse>> showAllUser(UserDto udetDto) {
		
		

		List<UserResponse> userRes = (List<UserResponse>) userService.showAllUser(udetDto);
		ResponseEntity<List<UserResponse>> res = null;

		try {
			res = new ResponseEntity<List<UserResponse>>((List<UserResponse>) userRes, HttpStatus.OK);

		} catch (Exception e) {
			res = new ResponseEntity<List<UserResponse>>((List<UserResponse>) userRes, HttpStatus.NOT_FOUND);

		}
return res;
}
	
}
