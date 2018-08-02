package com.apress.prospring4.ch5.DynamicPointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutExample {

	public static void main(String[] args) {
		SampleBean target = new SampleBean();
		Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvisor(advisor);
		factory.setTarget(target);
		
		SampleBean proxy = (SampleBean)factory.getProxy();
		
		proxy.foo(100);
		proxy.foo(10);
		proxy.foo(1);
		proxy.bar();
		proxy.bar();
		proxy.bar();
		
		
	}

}
