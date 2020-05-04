package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/")
	public String hello() {
		return "Hello Spring" ; 
	}
	
	@RequestMapping("/cars")
	public List<Car> getCars() {
		Car c1 = new Car("Toyota", "Camery", 2020);
		Car c2 = new Car("Toyota", "Corola", 2018);
		Car c3 = new Car("Toyota", "Yaris", 2020);
		
		return Arrays.asList(c1,c2,c3);
	}
}
