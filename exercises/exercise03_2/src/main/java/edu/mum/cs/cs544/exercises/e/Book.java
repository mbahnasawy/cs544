package edu.mum.cs.cs544.exercises.e;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String isbn;
	private String title;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name = "book_publisher")
	private Publisher author;

	public Book() {
	}

	public Book(String isbn, String title, Publisher author) {
	
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	public Book(String isbn, String title) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = null; 
	}

	public String toString() {
		return "Book ISBN: " + this.getIsbn() + 
				", Title: " + this.getTitle() +
				"Pulished by: " +this.getAuthor()!=null? this.getAuthor().getName(): "None";
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getAuthor() {
		return author;
	}

	public void setAuthor(Publisher author) {
		this.author = author;
	}

}
