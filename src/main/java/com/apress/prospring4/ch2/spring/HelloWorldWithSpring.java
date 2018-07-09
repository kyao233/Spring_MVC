package com.apress.prospring4.ch2.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.prospring4.ch2.MessageRenderer;

public class HelloWorldWithSpring {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/apress/prospring4/ch2/app-context.xml");
		MessageRenderer renderer = ctx.getBean("renderer", MessageRenderer.class);
		renderer.render();
	}
	
}
