package com.example.demo.repositry;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Student;

import edu.miu.common.repository.BaseRepository;

@Repository
public interface StudentRepository extends BaseRepository<Student, Integer> {

}
