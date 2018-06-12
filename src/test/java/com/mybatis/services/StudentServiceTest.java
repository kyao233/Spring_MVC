package com.mybatis.services;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.domain.Student;

public class StudentServiceTest {

	private static StudentService studentService;
	
	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}
	
	@AfterClass
	public static void teardown() {
		studentService = null;
	}
	
	@Test
	public void testfindAllStudent() {
		List<Student> studentList = studentService.findAllStudents();
		Assert.assertNotNull(studentList);
		for (Student student: studentList) {
			System.out.println(student);
		}
		
	}
	
	@Test
	public void testfindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	
	@Test
	public void testInsertStudent() {
		Student student = new Student();
		int id = 11;
		student.setStudId(id);
		student.setName("Kai");
		student.setEmail("koko@sina.com");
		student.setDob(new Date());
		studentService.insertStudent(student);
		Student newStudent = studentService.findStudentById(id);
		Assert.assertNotNull(newStudent);
	}
}
