package com.example.demo.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Student;
import com.example.demo.service.response.StudentResponse;

import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;

@Component
public class StudentResponseMapper extends BaseMapper<Student, StudentResponse>{

	@Autowired
	public StudentResponseMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Student.class, StudentResponse.class);
		// TODO Auto-generated constructor stub
	}

}
