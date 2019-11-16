package com.emmanuel.ejeds.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emmanuel.ejeds.service.UserService;

@Controller
public class UserRegistrationController {
	public static final String USER_REG = "/user/registration";
	public static final String VIEW = "registration";
	
	 private static final String USER = "user";
	
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = USER_REG)
	public String getRegistrationPage(Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute(USER, userForm);
		return VIEW;
	}

}
