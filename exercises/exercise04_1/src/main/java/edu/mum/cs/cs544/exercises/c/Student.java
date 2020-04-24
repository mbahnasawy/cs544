package edu.mum.cs.cs544.exercises.c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;

	@ManyToMany
	private List<Course> courses = new ArrayList<Course>();

	public Student() {
	}

	public Student(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void enrollmentInCourse(Course course) {
		course.addStudentToCourse(this);
		this.courses.add(course);
	}

	public String toString() {
		return "Student Name: " + this.getFirstName() + " " + this.getLastName();
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
