package edu.mum.cs.cs544.exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SecondaryTable(name = "Owners")
public class Vehicle {

	@Id
	private int id;
	@Column(table = "Owners")
    private String owner;
    private String make;
    private String model;
    private int year;
    private String color;
}
