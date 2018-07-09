package com.mybatis.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.domain.Address;
import com.mybatis.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-app-context.xml")
public class StduentServiceELSTest {
	
	@Autowired
	private StudentServiceELS studentService;
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		Address address = new Address();
		address.setAddrId(2);
		long ts = System.currentTimeMillis();
		student.setStudId(3);
		student.setName("stud_" + ts);
		student.setEmail("stud_" + ts + "@gamil.com");
		student.setAddress(address);
		Student stud = studentService.createStudent(student);
		Assert.assertNotNull(stud);
		Assert.assertEquals("stud_" + ts, student.getName());
		Assert.assertEquals("stud_" + ts + "@gamil.com", student.getEmail());
		System.out.println("createStudent:" + stud);
	}
	
	
}
