package com.userRoleProject.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.userRoleProject.entity.User;
import com.userRoleProject.entity.UserRole;
import com.userRoleProject.repository.UserRepository;
import com.userRoleProject.service.RoleService;
import com.userRoleProject.service.UserRoleService;
import com.userRoleProject.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	UserRepository userRepo;

	@GetMapping("/") // 1
	public String logout() {
		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user) {
		ModelAndView m = new ModelAndView("ouput");
		UserRole ur=null;
		User u = null;
		u = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		System.out.println(">>>>>"+u);
		if(!Objects.isNull(u)) {
		System.out.println("Output " + u.getEmail());

		System.out.println("Email= UI " + user.getEmail());
		System.out.println("PASSword= UI " + user.getPassword());

	
		Integer userId = u.getUserId();
		 ur = userRoleService.getId(userId);

		String S = "This user " + u.getEmail() + " has role " + ur.getRoleId().getRoleName()
				+ " is able to do the task as " + ur.getRoleId().getRoleDescription();
		m.addObject("massage", S);

		}else {
		
			m.addObject("massage", "user not found ");
			
		}


		System.out.println("hii");

		return m;

	}

}