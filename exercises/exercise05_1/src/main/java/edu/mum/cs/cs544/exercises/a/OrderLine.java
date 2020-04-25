package edu.mum.cs.cs544.exercises.a;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product product;

	public OrderLine() {
		super();
	}

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Quantity: " + this.getQuantity()+ ", Product Name: " + this.getProduct().getName() ; 
	}

}
