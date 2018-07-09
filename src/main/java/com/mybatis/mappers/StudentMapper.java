package com.mybatis.mappers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.domain.Student;

@Service
public interface StudentMapper {

	List<Student> findAllStudents();
	Student findStudentById(int id);
	void insertStudent(Student student);
}
