/*
 * package com.userRoleProject.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute;
 * 
 * import com.userRoleProject.entity.User; import
 * com.userRoleProject.repository.UserRepository;
 * 
 * @Controller public class WelcomeController {
 * 
 * @Autowired
 * 
 * UserRepository userRepo;
 * 
 * @GetMapping("/")//1 public String logout() { return "welcome"; }
 * 
 * @GetMapping("/user") public String addUser(@ModelAttribute User user) {
 * System.out.println(user); userRepo.save(user); return "user"; } } package
 * com.userRoleProject.controller;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.userRoleProject.entity.User; import
 * com.userRoleProject.repository.UserRepository;
 * 
 * @Controller public class FormController {
 * 
 * @Autowired private UserRepository userRepo;
 * 
 * @GetMapping("/userLogin") public String loginForm() {
 * 
 * return "login";
 * 
 * }
 * 
 * @GetMapping("/welcome") public String welcom() {
 * 
 * return "welcom";
 * 
 * }
 * 
 * @GetMapping("/userform") public String userForm(@ModelAttribute User u) {
 * System.out.println(u); //userRepo.save(u); return "user";
 * 
 * }
 * 
 * @GetMapping("/home") public String home(Model model, User user ) {
 * model.addAttribute("email","prrr"); model.addAttribute("password","1111");
 * 
 * return "login"; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @GetMapping("loginhere") public String login(Model model, String error,
 * String logout) { if(error !=null) {
 * model.addAttribute("error","Your Username & Password is invalid"); }
 * if(logout!=null) {
 * model.addAttribute("message","You have been logged out successfully"); }
 * return "login"; }
 * 
 * 
 * }
 */