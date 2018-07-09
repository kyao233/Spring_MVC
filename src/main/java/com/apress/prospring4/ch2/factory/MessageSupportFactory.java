package com.apress.prospring4.ch2.factory;

import java.io.FileInputStream;
import java.util.Properties;

import com.apress.prospring4.ch2.MessageProvider;
import com.apress.prospring4.ch2.MessageRenderer;

public class MessageSupportFactory {

	private static MessageSupportFactory instance;
	
	private Properties props;
	private MessageProvider provider;
	private MessageRenderer renderer;
	
	
	public MessageSupportFactory() {
		props = new Properties();
		try {
			
			props.load(new FileInputStream("src/main/resources/com/apress/prospring4/ch2/msf.properties"));
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			
			this.renderer = (MessageRenderer)Class.forName(rendererClass).newInstance();
			this.provider = (MessageProvider)Class.forName(providerClass).newInstance();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static {
		instance = new MessageSupportFactory();
	}

	public static MessageSupportFactory getInstance() {
		return instance;
	}

	public MessageProvider getProvider() {
		return provider;
	}

	public MessageRenderer getRenderer() {
		return renderer;
	}
	
	
	
}
