package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepo ; 
	
	@RequestMapping("/")
	public String hello(){
		return "Hello";
	}
	
	@RequestMapping("/students")
	public List<Student> getSudents(){
		return studentRepo.findAll();
	}
}
