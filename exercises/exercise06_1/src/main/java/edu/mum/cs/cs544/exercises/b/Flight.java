package edu.mum.cs.cs544.exercises.b;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String flightNumber;
	@Column(name = "source")
	private String from;
	@Column(name = "destination")
	private String to;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return "Flight Number: " + this.getFlightNumber() + ", from: " + this.getFrom() + " to: " + this.getTo()
				+ " travel on: " + this.getDate();
	}

	public Flight(String flightNumber, String from, String to, Date date) {

		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}

	public Flight() {

	
	}

}
