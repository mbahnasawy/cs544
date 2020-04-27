package edu.mum.cs.cs544.exercises;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle {

	private int numgears;
	@Embedded
	@AttributeOverride(name = "pressure" , column = @Column(name = "front_presure"))
    private Wheel front;
	@Embedded
	@AttributeOverride(name = "pressure" , column = @Column(name = "rear_presure"))
    private Wheel rear;
}
