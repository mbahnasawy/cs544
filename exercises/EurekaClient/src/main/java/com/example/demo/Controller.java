package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private ClientService clientService ; 
	
	@GetMapping("/students")
	public List<StudentResponse> getStudents(){
		return clientService.getStudents();
	}
}
