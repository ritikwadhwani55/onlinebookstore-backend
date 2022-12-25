package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.User;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.UserRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		this.bookRepo.findAll().forEach(( b) -> books.add((Book)b) );
		return books;
	}
	
	public Book getBookById(Integer id) {
		Book u = new Book();
		u.setBook_id(id);
		 Optional<Book> book= this.bookRepo.findById(id);
		 if(book.isPresent()) {
			 return book.get();
			
		 }
		 return null;
	}

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		Book u =this.bookRepo.save(book);
		return u;
	}

	public Book updateAUser(Book book, Integer id) {
		// TODO Auto-generated method stub
		return this.bookRepo.save(book);
		
	}

	public Book deleteBook(Integer id) {
		// TODO Auto-generated method stub
		Book deletedBook= this.getBookById(id);
		this.bookRepo.deleteById(id);
		System.out.print(deletedBook.getBook_id()+" "+deletedBook.getName());
		return deletedBook;
		
	}

	
	
	
}
