package com.apress.prospring4.ch5.BeforeAdvice;

public class SecurityManager {

	
	/**store login info for each thread.*/
	private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();
	
	public void login(String username, String password) {
		threadLocal.set(new UserInfo(username, password));
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public UserInfo getUserInfo() {
		return threadLocal.get();
	}
	
}
