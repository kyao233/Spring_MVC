package com.mybatis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.domain.Student;
import com.mybatis.mappers.StudentMapper;

@Repository
public class StudentServiceELS {

	@Autowired
	private StudentMapper studentMapper;
	
	

	public Student createStudent(Student student) {
		if (student.getName().equals("")) {
			throw new RuntimeException("username should not be empty");
		}
		this.studentMapper.insertStudent(student);
		return student;
	}
	
}
