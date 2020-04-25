package edu.mum.cs.cs544.exercise;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String appDate;
	@OneToOne
	private Patient patient;
	@OneToOne
	private Doctor doctor;
	
	@Embedded
	private Payment payment;

	public Appointment() {
		super();
	}

	public Appointment(String appDate, Patient patient, Payment payment, Doctor doctor) {
		super();
		this.appDate = appDate;
		this.patient = patient;
		this.payment = payment;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appoinment ID: " + this.getId() + 
				", Date: " + this.getAppDate() + 
				", Payment Date: " + this.getPayment().getPayDate()+
				", Amount: " + this.getPayment().getAmount() +
				", Patient: " + this.getPatient().getName() +
				" and the doctor: " + this.getDoctor().getFirstName() + " " + this.getDoctor().getLastName() ; 
				
				
 				
				
	}

}
