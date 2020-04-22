package edu.mum.cs.cs544.exercises;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String ISBN;
	private String author;
	private double price;
	private java.util.Date publish_date;
	
	
	public Book(String title, String iSBN, String author, double price, Date publish_date) {
		this.title = title;
		this.ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
	}
	
	// Default Constructor
	public Book() {
		
	}

	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public java.util.Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(java.util.Date publish_date) {
		this.publish_date = publish_date;
	}

	@Override
	public String toString() {
		return "Book Id: " + this.id +" ,Book title: " + this.title +" , ISBN: " + this.ISBN +
				" , Author: " + this.author + " , Price: " +  this.price + 
				" and Published on: " + this.publish_date; 
	}
	
}
