package com.wcp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	public static String goHome() {
		return "/index.html";
	}

	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
}
