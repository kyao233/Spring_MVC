package com.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitCompanyNameListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		setInitParam(servletContext, "companyName", "Apple");
		setInitParam(servletContext, "oldCompanyName", "OldApple");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
	
	private void setInitParam(ServletContext context, String attributeName, String defaultValue) {
		String initialValue = context.getInitParameter(attributeName);
		if(initialValue != null) {
			context.setAttribute(attributeName, initialValue);
		} else {
			context.setAttribute(attributeName, defaultValue);
		}
		context.log("set attribute: "+ attributeName);
	}

}
