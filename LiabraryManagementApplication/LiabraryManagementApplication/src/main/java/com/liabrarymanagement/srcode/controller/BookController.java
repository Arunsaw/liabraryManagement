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

import com.liabrarymanagement.srcode.dto.StudentDto;
import com.liabrarymanagement.srcode.entity.Books;
import com.liabrarymanagement.srcode.entity.Student;
import com.liabrarymanagement.srcode.servicesInterface.BookService;
import com.liabrarymanagement.srcode.servicesInterface.StudentServiceInterface;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired 
	StudentServiceInterface studentService ; 

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
		return mav;
	}
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Books books)
	{	bookService.update(books.getId(), books);	
		return "redirect:/listofbook";
	}
	@GetMapping("/Bookissue")
	public String issueBook(Model m)
	{
		m.addAttribute("Student", new StudentDto());
		return "Bookissue";
	}
	@PostMapping("/issueBook")
	public String issueBookSave(@ModelAttribute StudentDto studentDto)
	{	
		Books book=bookService.get(Long.parseLong(studentDto.getBookId()));
		Student s=studentService.getStudentByName(studentDto.getName());
		//s.setName(studentDto.getName());
		book.setStudent(s);
		bookService.saveBook(book);
	
		//Student st = new Student();
		/*
		 * st.setName(studentDto.getName());
		 * st.setIssuedBook(bookService.get(Long.parseLong(studentDto.getBookId())));
		 * studentService.saveStudent(st);
		 */
		
		return "redirect:/Bookissue" ; 
	}
}
