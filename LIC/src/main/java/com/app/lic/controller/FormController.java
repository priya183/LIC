package com.app.lic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;
import com.app.lic.repository.AppUsersRepo;
import com.app.lic.repository.PlanRepository;



@Controller
public class FormController

{
	@Autowired
	private AppUsersRepo userRepo;
	
	@Autowired
	private PlanRepository planRepository;
	
	@GetMapping("/home")
	public String home()
	{
		return "index";
	}
@GetMapping("/userform")
public String user(@ModelAttribute AppUsers u)
{
	
	
	
	System.out.println(u);
	//userRepo.save(u);
	return "user";
}

@GetMapping("/planDetails")
public String plan(@ModelAttribute Plan p)
{
	System.out.println(p);
	planRepository.save(p);
	return "plan";
}

}
