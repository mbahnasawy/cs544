package edu.mum.cs.cs544.exercises.c;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	@MapKey(name = "studentId")
	@JoinColumn(name ="school_id")
	private Map<Integer, Student> students = new HashMap<Integer, Student>();

	// Default Constructor
	public School() {

	}

	public School(String name) {

		this.name = name;
	}

	public void addStudentToSchool(Student student) {
		this.students.put(student.getStudentId(), student);
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

	public Map<Integer, Student> getStudents() {
		return students;
	}

	public void setStudents(Map<Integer, Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return " School Name : " + this.name;
	}

}
