package edu.mum.cs.cs544.exercise;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {

	private String payDate;
	private double amount;

	public Payment(String payDate, double amount) {
		super();
		this.payDate = payDate;
		this.amount = amount;
	}

	public Payment() {
		super();
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
