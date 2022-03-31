package com.liabrarymanagement.srcode.servicesInterfaceimp;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liabrarymanagement.srcode.entity.Books;
import com.liabrarymanagement.srcode.repository.BookRepositoryInterface;
import com.liabrarymanagement.srcode.servicesInterface.BookService;
@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookRepositoryInterface repo ; 
	public void saveBook(Books b ) {
		
		repo.save(b);
	}
	public List<Books> listAll(){
		return repo.findAll();
	}
	public void deleteBook(Long id)
	{
		repo.deleteById(id);
	}
	public void update(Long id ,Books b)
	{	
		Books book = repo.getById(id);
		book.setAuthor(b.getAuthor());
		book.setCategories(b.getCategories());
		book.setName(b.getName());
		book.setDescription(b.getDescription());
		repo.save(book);
		
	}
	public Books get(Long id) {
		return repo.findById(id).get();
	}
	
	

}
