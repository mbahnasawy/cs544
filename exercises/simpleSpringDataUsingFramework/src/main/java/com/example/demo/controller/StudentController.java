package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;
import com.example.demo.repositry.StudentRepository;
import com.example.demo.service.response.StudentResponse;

import edu.miu.common.controller.BaseReadController;

@RestController
@RequestMapping("/students")
public class StudentController extends BaseReadController<StudentResponse, Student, Integer>{

	@Autowired
	StudentRepository studentRepo ; 
}
