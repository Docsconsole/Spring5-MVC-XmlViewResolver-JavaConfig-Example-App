package com.docsconsole.tutorials.springmvc5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/getHelloMessage", method = RequestMethod.GET)
	public String getHelloMessage(ModelMap model) {
		
		model.addAttribute("msg", "Spring5 MVC XmlViewResolver JavaConfig Example !!");
		return "home";
		
	}
}