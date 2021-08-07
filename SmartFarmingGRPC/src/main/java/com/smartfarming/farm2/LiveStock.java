package com.smartfarming.farm2;

public class LiveStock {
	
	private String animal;
	private int price;
	
	

	LiveStock(String animal, int price) {
		this.animal =animal;
		this.price=price;
		
		
	}
	
	
	public void setPrice(int price) {
		this.price =price;
	}
	
	
	public int getPrice() {
		return this.price;
	}
	
	public String getAnimal() {
		return this.animal;
		
	}
	
	
}
