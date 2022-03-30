package com.liabrarymanagement.srcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liabrarymanagement.srcode.entity.Books;

@Controller
public class BookController {

	@GetMapping("/addBook")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Books book = new Books();
		mav.addObject("Books", book);
		return mav;
	}
}
