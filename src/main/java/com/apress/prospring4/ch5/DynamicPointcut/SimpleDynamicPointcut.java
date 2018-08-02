package com.apress.prospring4.ch5.DynamicPointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;


public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
	
	
	@Override
	public boolean matches(Method arg0, Class<?> arg1) {
		System.out.println("Static method check for " + arg0.getName());
		return arg0.getName().equals("foo");
	}
	
	@Override
	public boolean matches(Method arg0, Class<?> arg1, Object[] arg2) {
		System.out.println("Dynamic method check for " + arg0.getName());
		int x = ((Integer) arg2[0]).intValue();
		return (x != 100);
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> cls) {
				return cls == SampleBean.class;
			}
		};
	}
	
}
