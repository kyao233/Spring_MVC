package com.apress.prospring4.ch5.AOP;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {

	public static void main(String[] args) {
		
		MessageWriter target = new MessageWriter();
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new MessageDecorator());
		factory.setTarget(target);
		// use proxy class to override another class.
		MessageWriter proxy = (MessageWriter)factory.getProxy();
		
		target.writeMessage();
		System.out.println("");
		proxy.writeMessage();
		
	}

}
