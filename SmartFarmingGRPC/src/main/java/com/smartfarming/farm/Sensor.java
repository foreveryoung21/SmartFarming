package com.smartfarming.farm;

public class Sensor {
	

	private String status;
	
	
	Sensor(String status){
	
		this.status=status;
		
	}
	

	
	
	

	
	
	public void setStatus(String status) {
		
		this.status = status;
	}
	
	
	public String getStatus () {
		return this.status;
		
	}
	
	
	 @Override
	    public String toString() {
	    	String print = "the status is "+this.status;
	    	
	    	
	    	
	        return print;
	    }
	 
	
}
