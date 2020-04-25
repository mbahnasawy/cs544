package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.mum.cs.cs544.exercises.a.Product;

@Entity
public class Book extends Product {

	private String title ;

	public Book() {
	
	}
	
	public Book(String title, String description) {
		super("Book", description);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 
	
	

}
