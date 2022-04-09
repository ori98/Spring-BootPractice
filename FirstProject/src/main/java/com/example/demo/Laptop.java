package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lappy")					// this is used to specify name for component (default it laptop)
public class Laptop {
	private int ram;
	private String gpu;
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	@Override
	public String toString() {
		return "Laptop [ram=" + ram + ", gpu=" + gpu + "]";
	}
	
	// a method to test if it is accessible in other bean
	public void working() {
		System.out.println("Laptop is working avengers!");
	}
	
}
