package com.example.bookstore.models;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.tuple.GenerationTiming;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer book_id;
	private String name;
	@Column(unique=true)
	private String descrip;
	private double price;
	@Column(name="image")
	private String image_url;
	
	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LocalDateTime getDate_created() {
		return date_created;
	}

	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}

	public LocalDateTime getLast_updated() {
		return last_updated;
	}

	public Book(BookResponse br) {
		this.book_id= br.getBook_id();
		this.count= br.getCount();
		this.date_created= br.getDate_created();
		this.last_updated= br.getLast_updated();
		this.price= br.getPrice();
		this.descrip= br.getDescrip();
		this.image_url= br.getImage_url();
		this.name= br.getName();
//		br.getCategories().forEach(c -> this.authors.add())); 
// @formatter:on

	}
	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	private Integer count;
	 @CreationTimestamp
	private LocalDateTime date_created;
	@CurrentTimestamp(timing = GenerationTiming.ALWAYS)
	private LocalDateTime last_updated;
	
	@ManyToMany(mappedBy="books")
	@JsonIgnore
	private List<Author> authors=new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		        name="book_category",
		        joinColumns={@JoinColumn(name="book_bookid", referencedColumnName="book_id")},
		        inverseJoinColumns={@JoinColumn(name="category_categoryid", referencedColumnName="c_id")})
	private List<Category> categories = new ArrayList<>();

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
