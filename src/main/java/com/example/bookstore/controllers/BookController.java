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
import com.example.bookstore.models.BookResponse;
import com.example.bookstore.models.Category;
import com.example.bookstore.models.User;
import com.example.bookstore.repositories.AuthorRepository;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.CategoryRepository;
import com.example.bookstore.services.BookService;
import com.example.bookstore.services.UserService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping("/greetings")
	public String getResp() {
		return "Hello!!";
	}
	
	@RequestMapping("/")
	public List<Book> getAllBooks() {
		List<Book> books= this.bookService.getAllBooks();
//		List<BookResponse> bookResp = new ArrayList<>();
//		books.forEach(b -> {
//			BookResponse br =new BookResponse();
//			br.setCount(b.getCount());
//			br.setDate_created(b.getDate_created());
//			br.setDescrip(b.getDescrip());
//			br.setImage_url(b.getImage_url());
//			br.setLast_updated(b.getLast_updated());
//			br.setName(b.getName());
//			br.setPrice(b.getPrice());
//			br.setBook_id(b.getBook_id());
//			List<Integer> category_ids= new ArrayList<>();
//			for(Category c: b.getCategories()) {
//				category_ids.add(c.getC_id());
//			}
//			br.setCategory_ids_list(category_ids);
//			bookResp.add(br);
//		});
		return books;
		
	}
	@RequestMapping("/{id}")
	public Book getUserById(@PathVariable("id") Integer book_id) {
		return this.bookService.getBookById(book_id);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public Book addUser(@RequestBody() BookResponse book) {
		Book b = new Book(book);
		
		book.getCategory_ids_list().forEach(c_id -> {
			if(this.categoryRepository.findById(c_id).isPresent()) 
			b.getCategories().add(this.categoryRepository.findById(c_id).get());
			else { 
			}
		}
	);
		
//		book.getAuthor_ids_list().forEach(a_id -> b.get.add(this.authorRepository.findById(a_id).get()));
		Book newBook = this.bookService.addBook(b);
//		Author authorWithNewBook= this.authorRepository.save(authorWithNewBook);
		List<Author> authorsWithNewBook = new ArrayList<>();
				
				newBook.getAuthors().forEach(a -> authorsWithNewBook.add(a));
		for(Author auth: authorsWithNewBook) {
			authorRepository.findById(auth.getA_id()).get().getBooks().add(newBook);
			this.authorRepository.save(auth);
		}
		return newBook;
//		newBook.getAuthors().forEach(a -> this.authorRepository.findById(a.getA_id()).get().getBooks().add(newBook));
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Book updateUser(@PathVariable("id") Integer id, @RequestBody() Book book) {
		return this.bookService.updateAUser(book, id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public Book deleteUserById(@PathVariable("id") Integer id) {
		return this.bookService.deleteBook(id);
	}
}
