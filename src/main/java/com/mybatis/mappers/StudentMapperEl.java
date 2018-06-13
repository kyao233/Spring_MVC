package com.mybatis.mappers;


import java.util.List;
import com.mybatis.domain.Student;

public interface StudentMapperEl {

	List<Student> findAllStudents();
	Student selectStudentWithAddress(int studId);
	
}
