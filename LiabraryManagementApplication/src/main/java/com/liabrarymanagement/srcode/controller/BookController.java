package com.liabrarymanagement.srcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liabrarymanagement.srcode.entity.Books;
import com.liabrarymanagement.srcode.servicesInterface.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/addBook")
	public String addEmployeeForm(Model m) {
		m.addAttribute("Books", new Books());

		return "add-book-file";
	}

	@PostMapping("/addingBook")
	public String addingBook(@ModelAttribute Books books) {
		bookService.saveBook(books);
		return "redirect:/addBook";
	}
	
	@GetMapping("/listofbook")
	public String listBook(Model m)
	{	
		List<Books> bookslist = bookService.listAll();
		m.addAttribute("books",bookslist);
		return "ListOfBook";
	}
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable(name = "id") long id)
	{
		bookService.deleteBook(id);
		return "redirect:/listofbook";
	}
	@GetMapping("edit/{id}")
	public ModelAndView editBook(@PathVariable(name="id") Long id   )
	{	
		ModelAndView mav = new ModelAndView("updatebook");
		Books book = bookService.get(id);
		mav.addObject("Books",book );
		bookService.update(id, book);
		return mav;
	}
//	@GetMapping("/updateBook")
//	public String updateBook()
//	{
//		
//	}
}
