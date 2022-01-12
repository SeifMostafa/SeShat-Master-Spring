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
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") long theId) {
		
		userService.delete(theId);
		return "redirect:/user/list";
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
		
		// save the user using our service
		userService.saveUser(user);
		
		return "redirect:/user/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") long theId,
									Model theModel) {
		
		// get the user from our service
		User user = userService.getUser(theId);	
		
		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("user", user);
		
		// send over to our form		
		return "user-form";
	}
}
