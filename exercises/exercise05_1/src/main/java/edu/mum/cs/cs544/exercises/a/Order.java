package edu.mum.cs.cs544.exercises.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`Order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public Order() {

	}

	public Order(Date date) {
		this.date = date;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + this.getOrderId() + 
				", On: " + this.getDate() +
				"has the following orderlines: " + 
				orderLines.toString() ;
	}

}
