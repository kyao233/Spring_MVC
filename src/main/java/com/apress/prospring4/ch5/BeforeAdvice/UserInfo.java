package com.apress.prospring4.ch5.BeforeAdvice;

public class UserInfo {
	
	
	/**date structure storing login info.*/
	public UserInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	private String username;
	private String password;
}
