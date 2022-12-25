package com.example.bookstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.models.Author;
import com.example.bookstore.models.AuthorResponse;
import com.example.bookstore.models.Book;
import com.example.bookstore.models.Category;
import com.example.bookstore.models.User;
import com.example.bookstore.services.AuthorService;
import com.example.bookstore.services.CategoryService;
import com.example.bookstore.services.UserService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("/greetings")
	public String getResp() {
		return "Hello!!";
	}
	
	@RequestMapping("/")
	public List<AuthorResponse> getAllAuthors() {
		List<Author> authors= this.authorService.getAllAuthors();
		List<AuthorResponse> authResp = new ArrayList<>();
		authors.forEach(a -> {
			AuthorResponse ar =new AuthorResponse();
			ar.setA_id(a.getA_id());
			ar.setName(a.getName());
			List<Integer> book_ids= new ArrayList<>();
			for(Book b: a.getBooks()) {
				book_ids.add(b.getBook_id());
			}
			ar.setBook_ids(book_ids);
			authResp.add(ar);
		});
		return authResp;
	}
	@RequestMapping("/{id}")
	public Author getAuthorById(@PathVariable("id") Integer c_id) {
		return this.authorService.getAuthorById(c_id);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public Author addAuthor(@RequestBody() AuthorResponse c) {
		Author auth = new Author(c);
		auth.setBooks(new ArrayList<>());
		return this.authorService.addAuthor(auth);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Author updateAuthor(@PathVariable("id") Integer id, @RequestBody() AuthorResponse author) {
		Author auth = new Author(author);
		auth.setBooks(new ArrayList<>());
		 auth= this.authorService.updateAuthor(auth, id);
		 return auth;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deleteCategoryById(@PathVariable("id") Integer id) {
		Author auth= this.authorService.getAuthorById(id);
		this.authorService.deleteAuthor(id);
		return "Author with id "+auth.getA_id()+" has been deleted!";
	}
}

