package edu.mum.cs.cs544.exercise;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST) 
	private Set<Laptop> laptops = new HashSet<Laptop>();

	public Employee() {
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee Number: " + this.getId() + ", Name: " + this.getFirstName() + " " + this.getLastName();
	}
	
	public void addLaptop(Laptop laptop) {
		laptop.setOwner(this);
		this.laptops.add(laptop);
	}

	public Set<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(Set<Laptop> laptops) {
		this.laptops = laptops;
	}
	
	
}
