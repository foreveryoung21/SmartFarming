package com.smartfarming.farm2;

public class Animal {
	private int weight;
	private String liveStockName;
	
	
	
	
	
	Animal(int weight,String liveStockName)  {
		this.liveStockName=liveStockName;
		this.weight =weight;
	}
	
	
	public int getWeight() {
		return this.weight;
	}
	
	
	public String getAnimal() {
		return this.liveStockName;
	}
	
	
	public void setAnimal(String liveStockName) {
		this.liveStockName= liveStockName;
	}

	
	@Override
    public String toString() {
   
    	
    	
    	
        return ""+ this.getAnimal();
    }

}
