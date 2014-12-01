package com.mercury.timesheet.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/reporting")
	public String reportPage() {
		return "reporting";
	}
}
