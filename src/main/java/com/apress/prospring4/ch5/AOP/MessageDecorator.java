package com.apress.prospring4.ch5.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.print("Hello, ");
		Object ret = method.proceed();
		System.out.println("!");
		return ret;
	}
	
}
