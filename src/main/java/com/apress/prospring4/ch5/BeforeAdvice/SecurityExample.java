package com.apress.prospring4.ch5.BeforeAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {

	public static void main(String[] args) {
		SecurityManager securityManager = new SecurityManager();
		SecureBean bean = getSecureBean();
		
		securityManager.login("kai", "kai");
		bean.printMessage();
		securityManager.logout();
		
		try {
			securityManager.login("invalidUser", "kai");
			bean.printMessage();
		} catch(SecurityException e) {
			e.printStackTrace();
		} finally {
			securityManager.logout();
		}
		
		try {
			bean.printMessage();
		} catch(SecurityException e) {
			e.printStackTrace();
		}
		
	}

	private static SecureBean getSecureBean() {
		SecureBean target = new SecureBean();
		
		ProxyFactory factory = new ProxyFactory();
		
		SecurityAdvice advice = new SecurityAdvice();
		factory.addAdvice(advice);
		factory.setTarget(target);
		
		return (SecureBean) factory.getProxy();
	}
	
	
	
}
