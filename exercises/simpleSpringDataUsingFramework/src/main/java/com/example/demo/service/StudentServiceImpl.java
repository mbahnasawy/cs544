package com.example.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Student;
import com.example.demo.service.response.StudentResponse;

import edu.miu.common.service.BaseReadServiceImpl;

@Service
@Transactional
public class StudentServiceImpl extends BaseReadServiceImpl<StudentResponse, Student, Integer> implements StudentService{


}
