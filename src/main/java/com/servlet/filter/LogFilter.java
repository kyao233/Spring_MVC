package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	private ServletContext servletContext;
	
	private String filterName;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.servletContext = filterConfig.getServletContext();
		this.filterName = filterConfig.getFilterName();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		this.servletContext.log("filterName: " + filterName + 
				"context path: " + this.servletContext.getContextPath()); //获取应用程序上下文路径
	}

	@Override
	public void destroy() {

	}

}
