package edu.mum.cs.cs544.exercises.f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String romeNumber;
	private String buildingNumber;
	@OneToMany(mappedBy = "office")
	private List<Employee> employees = new ArrayList<Employee>();

	// Default Constructor
	public Office() {

	}

	public Office(String romeNumber, String buildingNumber) {
		super();
		this.romeNumber = romeNumber;
		this.buildingNumber = buildingNumber;
	}

	public void addEmployee(Employee employee) {
		employee.setOffice(this);
		this.employees.add(employee);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRomeNumber() {
		return romeNumber;
	}

	public void setRomeNumber(String romeNumber) {
		this.romeNumber = romeNumber;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
