package com.wcp.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	public static String goHome() {
		return "/index.html";
	}

}
