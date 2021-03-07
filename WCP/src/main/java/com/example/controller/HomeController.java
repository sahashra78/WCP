package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.repositories.CategoryRepository;
import com.example.repositories.ProductRepository;

@Controller
public class HomeController {
	
	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;
	
	@GetMapping("/")
	public String goHome(Model model) {
		return "/home.html";
	}
	
	@GetMapping("/item")
	public String itemPage() {
		return "/item.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
}