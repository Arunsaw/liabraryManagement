package com.liabrarymanagement.srcode.servicesInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liabrarymanagement.srcode.entity.Books;
@Service
public interface BookService {
	
	public  void saveBook(Books b) ;
	public List<Books> listAll();
	public void deleteBook(Long id);
	public void update(Long id , Books b);
	public Books get(Long id);
	
}
