package com.example.bookstore.models;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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


public class BookResponse {
	
	private Integer book_id;
	private String name;
	
	private String descrip;
	private double price;
	
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

	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	


	private Integer count;
	 
	private LocalDateTime date_created;
	
	private LocalDateTime last_updated;
	
	private List<Integer> category_ids_list = new ArrayList<>();
	
	private List<Integer> author_ids_list = new ArrayList<>();

	public List<Integer> getCategory_ids_list() {
		return category_ids_list;
	}

	public void setCategory_ids_list(List<Integer> category_ids_list) {
		this.category_ids_list = category_ids_list;
	}

	public List<Integer> getAuthor_ids_list() {
		return author_ids_list;
	}

	public void setAuthor_ids_list(List<Integer> author_ids_list) {
		this.author_ids_list = author_ids_list;
	} 
}
