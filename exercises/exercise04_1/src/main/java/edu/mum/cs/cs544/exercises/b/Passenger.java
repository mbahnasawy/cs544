package edu.mum.cs.cs544.exercises.b;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST) // no need to put mapped by because it is uni-directional relation
	private java.util.Collection<Flight> flights = new ArrayList<Flight>();

	public Passenger() {

	}

	public Passenger(String name) {
		this.name = name;
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
		return "Passenger Id: " + this.id + " ,Name : " + this.name;
	}
	
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}

	public java.util.Collection<Flight> getFlights() {
		return flights;
	}

	public void setFlights(java.util.Collection<Flight> flights) {
		this.flights = flights;
	}

}
