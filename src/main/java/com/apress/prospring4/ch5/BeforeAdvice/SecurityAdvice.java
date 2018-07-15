package com.apress.prospring4.ch5.BeforeAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {

	private SecurityManager securityManager;
	
	public SecurityAdvice() {
		securityManager = new SecurityManager();
	}
	
	@Override
	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		UserInfo userInfo = securityManager.getUserInfo();
		if (userInfo == null) {
			throw new SecurityException("No user authenticated!\n "
					+ "access not allowed for method " + method.getName());
		} else if ("kai".equals(userInfo.getUsername())) {
			System.out.println("Kai is allowed user -- OK!!!");
		} else {
			throw new SecurityException(userInfo.getUsername() + " is not allowed user!!! "
					+ "access not allowed for method " + method.getName());
		}
	}

}
