package com.ori98.firstwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ori98.firstwebsite.pojo.Person;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Person myPerson) {
		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("personObj", myPerson);
		modelView.setViewName("home");
		
		return modelView;
	}
}
