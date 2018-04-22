package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

	
	Logger logger = Logger.getLogger("cartAuditLogger");
	
	@RequestMapping
	public String get(HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		logger.info(String.format("init cart request session ID: %s ", sessionId));
		return "redirect:/cart/" + sessionId;
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
	
}
