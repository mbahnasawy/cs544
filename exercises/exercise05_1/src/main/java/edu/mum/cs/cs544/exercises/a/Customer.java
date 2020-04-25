package edu.mum.cs.cs544.exercises.a;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@MapKey(name = "orderId")
	private Map<Integer, Order> orders = new HashMap<Integer, Order>();
	
	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void addOrder(Order order) {
		order.setCustomer(this);
		orders.put(order.getOrderId(), order); 
	}

	
	public Map<Integer, Order> getOrders() {
		return orders;
	}

	public void setOrders(Map<Integer, Order> orders) {
		this.orders = orders;
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
		return "Customer ID: " + this.getId() + ", Name: " + this.getFirstName() + " " + this.getLastName();
	}
	
	
	
}
