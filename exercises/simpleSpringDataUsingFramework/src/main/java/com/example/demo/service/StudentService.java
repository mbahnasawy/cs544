package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.service.response.StudentResponse;

import edu.miu.common.service.BaseReadService;
import edu.miu.common.service.BaseReadServiceImpl;

public interface StudentService extends BaseReadService<StudentResponse, Student, Integer>{

}
