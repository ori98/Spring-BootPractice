package com.ori98.jpawebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ori98.jpawebsite.dao.AvengerRepo;
import com.ori98.jpawebsite.model.Avenger;

@RestController
@RequestMapping("/api")
public class RestHomeController {
	
	@Autowired
	AvengerRepo avengerRepo;
	
	@GetMapping("/avengers")
	public List<Avenger> getAvenger(){
		return avengerRepo.findAll();
	}
	
	@PostMapping(path = "/avenger", consumes = {"application/json"})
	public Avenger addAvenger(@RequestBody Avenger avenger) {
		avengerRepo.save(avenger);
		return avenger;
	}
	
	// for deleting avenger
	// note that the path remains the same even for delete request
	@DeleteMapping(path = "/avenger/{aId}")
	public Avenger deleteAvenger(@PathVariable int aId) {
		Avenger avenger = avengerRepo.findById(aId).orElse(new Avenger());
		avengerRepo.delete(avenger);
		return avenger;
	}
	
	@PutMapping(path = "/avenger", consumes = {"application/json"})
	public Avenger saveOrUpdate(@RequestBody Avenger avenger) {
		avengerRepo.save(avenger);
		return avenger;
	}
}
