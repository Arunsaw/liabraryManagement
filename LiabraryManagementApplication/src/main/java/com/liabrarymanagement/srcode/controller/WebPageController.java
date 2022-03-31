package com.liabrarymanagement.srcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.liabrarymanagement.srcode.admin.Admin;

@Controller
public class WebPageController {

	@GetMapping("/")
	public String homePage()
	{
		return "Login";
	}
	@PostMapping("/login")
	public String admin(@ModelAttribute Admin a)
	{
		if(a.getEmail().equals("arun") && a.getPassword().equals("arun"))
		{
			return "redirect:/addBook";
		}
		else
			return "redirect:/";
	}
	
	
	
	
}
