package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class Avenger {
	private int aid;
	private String aname;
	
	@Autowired()						// lets spring know that there is already an instance in container
	@Qualifier("lappy")
	private Laptop laptop;
	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Avenger() {
		super();
		
		System.out.println("Avenger Created");
	}
	
	public void show() {
		System.out.println("I am an avenger");
		laptop.working();
	}
}
