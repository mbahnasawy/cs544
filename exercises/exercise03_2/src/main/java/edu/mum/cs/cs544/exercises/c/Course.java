package edu.mum.cs.cs544.exercises.c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String courseNumber;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<Student>();

	// Default Constructor
	public Course() {

	}

	public Course(String name, String courseNumber) {
	
		this.name = name;
		this.courseNumber = courseNumber;
	}


	public void addStudentToCourse(Student student) {
		this.students.add(student);
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

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Publisher Id: " + this.id + " ,Name : " + this.name;
	}

}
