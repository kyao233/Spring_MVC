package com.mybatis.services;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.domain.Course;
import com.mybatis.domain.Tutor;

public class TutorServiceElTest {

	
	private static TutorServiceEl tutorService;
	
	@BeforeClass
	public static void setup() {
		tutorService = new TutorServiceEl();
	}
	
	@AfterClass
	public static void tearDown() {
		tutorService = null;
	}
	
	
	@Test
	public void testFindTutorById() {
		int tutorId = 1;
		Tutor tutor = tutorService.findTutorById(tutorId);
		Assert.assertNotNull(tutor);
		System.out.println("Name:" + tutor.getName());
		Assert.assertNotNull(tutor.getCourses());
		for(Course c: tutor.getCourses()) {
			System.out.println("Course Id:" + c.getCourseId());
			System.out.println("Description:" + c.getDescription());
		}
	}
	
}
