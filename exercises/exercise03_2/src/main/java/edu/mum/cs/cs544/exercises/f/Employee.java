package edu.mum.cs.cs544.exercises.f;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeNumber;
	private String name;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department dept;

	@ManyToOne
	@JoinColumn(name = "office_id")
	private Office office;

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String toString() {
		return "Employee Number= " + this.getEmployeeNumber() + ", Name= " + this.getName() + ", Departmenet= "
				+ this.getDept();
	}

}
