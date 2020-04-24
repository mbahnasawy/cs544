package edu.mum.cs.cs544.exercises.e;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation (Reservation r) {
		this.reservations.add(r);
	}

	public Customer(String name) {

		this.name = name;
	}

	// Default Constructor
	public Customer() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer Id: " + this.id + " ,Name : " + this.name ;
	}

}
