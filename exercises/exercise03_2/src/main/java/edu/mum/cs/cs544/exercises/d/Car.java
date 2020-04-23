package edu.mum.cs.cs544.exercises.d;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String year;
	private double price;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Owner owner;

	public Car() {
	}

	public Car(String brand, String year, double price, Owner owner) {
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner = owner ; 
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public String toString() {
		return "Brand= " + this.getBrand() + 
				", Year= "+ this.getYear() + 
				", price= " + this.getPrice() + 
				" and the owner is: " + owner.getName() ; 
	}

}
