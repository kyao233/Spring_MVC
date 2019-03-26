package com.packt.webstore.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing webstore");
		System.out.println(context.getAttribute("companyName") 
				+ "\n" + context.getAttribute("formerCompanyName"));
		
		return "welcome";
	}
	
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting/redirect")
	public String greetingRedirect() {
		return "welcome";
	}
}
