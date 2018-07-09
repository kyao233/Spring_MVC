package com.apress.prospring4.ch2.impl;

import com.apress.prospring4.ch2.MessageProvider;
import com.apress.prospring4.ch2.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;
	
	
	@Override
	public void render() {
		if(messageProvider == null) {
			throw new RuntimeException("Message provider cannot be null.");
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
	

}
