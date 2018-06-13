package com.mybatis.services;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.domain.Course;
import com.mybatis.domain.Student;
import com.mybatis.domain.Tutor;

public class StudentServiceElTest {

	private static StudentServiceEl studentService = null;
	
	
	@BeforeClass
	public static void setup() {
		studentService = new StudentServiceEl();
	}
	
	@AfterClass
	public static void teardown() {
		studentService = null;
	}
	
	@Test
	public void testFindAllStudent() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		System.out.println("Name:" + students.get(0).getName());
		System.out.println("Email:" + students.get(0).getEmail());
		System.out.println("Phone:" + students.get(0).getPhone());
	}
	
	
	@Test
	public void testSelectStudentWithAddress() {
		int studId = 1;
		Student student = studentService.selectStudentWithAddress(studId);
		Assert.assertNotNull(student);
		Assert.assertNotNull(student.getAddress());
		System.out.println("Name:" + student.getName());
		System.out.println("Email:" + student.getEmail());
		System.out.println("Phone:" + student.getPhone());
		System.out.println("City:" + student.getAddress().getCity());
	}
	
	
	
}
