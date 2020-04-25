package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;

import edu.mum.cs.cs544.exercises.a.Product;

@Entity
public class CD extends Product {

	private String artist;

	public CD() {

	}

	public CD(String artist, String description) {
		super("CD", description);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}
