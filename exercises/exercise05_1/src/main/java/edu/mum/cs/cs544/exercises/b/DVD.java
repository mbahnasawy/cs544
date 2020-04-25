package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.mum.cs.cs544.exercises.a.Product;

@Entity
public class DVD extends Product {

	private String genre;

	public DVD() {

	}

	public DVD(String genre, String description) {
		super("DVD" , description);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
