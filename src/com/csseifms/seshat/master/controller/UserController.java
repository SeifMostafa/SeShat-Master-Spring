package com.csseifms.seshat.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/list")
	public String list() {
		//new ArrayList<User>();
		return "list-users";
	}
}
