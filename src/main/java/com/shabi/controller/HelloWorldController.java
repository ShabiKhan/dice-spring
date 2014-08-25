package com.shabi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hello1")
	public ModelAndView helloWorld() {

		String message = "Hello World, Spring 3.0!";
		return new ModelAndView("hello2", "message", message);
	}
}
/*
 * deleting some comments 
 */