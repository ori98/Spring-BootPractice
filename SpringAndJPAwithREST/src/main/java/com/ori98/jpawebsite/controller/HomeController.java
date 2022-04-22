package com.ori98.jpawebsite.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ori98.jpawebsite.dao.AvengerRepo;
import com.ori98.jpawebsite.model.Avenger;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
		AvengerRepo avengerRepo;
	
	@RequestMapping("")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("addAvenger")
	public String addAvenger(Avenger avenger) {
		avengerRepo.save(avenger);
		return "home.jsp";
	}
	
	@RequestMapping("getAvenger")
	public ModelAndView getAvenger(@RequestParam int aId) {
		
		ModelAndView mv = new ModelAndView("avenger.jsp");
		Avenger avenger = avengerRepo.findById(aId).orElse(new Avenger());
		
		// other ways to find avengers:
		System.out.println(avengerRepo.findByaPower("strength"));
		System.out.println(avengerRepo.findByaIdGreaterThan(101));
		System.out.println(avengerRepo.findByaPowerSorted("smash"));
		mv.addObject(avenger);
		return mv;
	}
	
	@RequestMapping("updateAvenger")
	public ModelAndView updateAvenger(@RequestParam int aId, @RequestParam String aPower) {
		ModelAndView mv = new ModelAndView("avenger.jsp");
		Avenger avenger = avengerRepo.findById(aId).orElse(new Avenger());
		avengerRepo.delete(avenger);
		// updating the values
		avenger.setaPower(aPower);
		avengerRepo.save(avenger);
		mv.addObject(avenger);
		return mv;
	}
	
		@RequestMapping(path = "avengers", produces = {"application/xml"})	// to restrict the output to xml
		@ResponseBody
		public List<Avenger> allAvenger() {
			return avengerRepo.findAll();
		}
	
	@RequestMapping("avenger/{aId}")
	@ResponseBody
	public Optional<Avenger> wildCardAvenger(@PathVariable("aId") int aId) {
		
		return avengerRepo.findById(aId);
	}
}