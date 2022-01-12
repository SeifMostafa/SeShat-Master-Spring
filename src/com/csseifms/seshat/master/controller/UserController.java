package com.csseifms.seshat.master.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csseifms.seshat.master.model.User;
import com.csseifms.seshat.master.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/list")
	public String list(Model model) {
		List<User>users = userService.getUsers();
		model.addAttribute("users", users);
		return "list-users";
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		User user = new User();
		
		theModel.addAttribute("user", user);
		
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		
		// save the customer using our service
		userService.saveUser(user);
		
		return "redirect:/user/list";
	}
	
}
