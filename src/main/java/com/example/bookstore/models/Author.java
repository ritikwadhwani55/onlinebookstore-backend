package com.example.bookstore.models;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer a_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Column()
	private String name;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="aircraftTypeId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		        name="author_book",
		        joinColumns={@JoinColumn(name="author_authorid", referencedColumnName="a_id")},
		        inverseJoinColumns={@JoinColumn(name="book_bookid", referencedColumnName="book_id")})
	private List<Book> books;
	
	
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer c_id) {
		this.a_id = c_id;
	}
	
	public Author(Integer a_id, String author) {
		super();
		this.a_id = a_id;
		this.name = author;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(AuthorResponse re){
		this.a_id= re.getA_id();
		this.name= re.getName();
	}
	
}
	