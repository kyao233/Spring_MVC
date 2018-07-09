package com.apress.prospring4.ch2.decouple;

import com.apress.prospring4.ch2.MessageProvider;
import com.apress.prospring4.ch2.MessageRenderer;
import com.apress.prospring4.ch2.impl.HelloWorldMessageProvider;
import com.apress.prospring4.ch2.impl.StandardOutMessageRenderer;

public class HelloWorldDecoupled {

	public static void main(String[] args) {
		MessageProvider provider = new HelloWorldMessageProvider();
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider);
		renderer.render();
	}
}
