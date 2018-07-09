package com.apress.prospring4.ch2.impl;

import com.apress.prospring4.ch2.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World!!!";
	}

}
