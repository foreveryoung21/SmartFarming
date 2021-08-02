package com.smartfarming.farm2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Logger;
import java.lang.Math;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


import com.smartfarming.farm2.CountResponse;
import com.smartfarming.farm.WaterRequest;
import com.smartfarming.farm.WaterResponse;
import com.smartfarming.farm2.CountRequest;

import com.smartfarming.farm2.FarmService2Grpc.FarmService2ImplBase;

public class FarmServer2 extends FarmService2ImplBase {
	private static final Logger logger = Logger.getLogger(FarmServer2.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		FarmServer2 farmserver = new FarmServer2();
		   
	    int port = 50054;
	    Server server = ServerBuilder.forPort(port)
	        .addService(farmserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
		
	}
	
	
	
	public void animalCount(CountRequest request, 
			StreamObserver<CountResponse> responseObserver) {
		
		String animal1 = request.getAnimal1();
		String animal2 = request.getAnimal2();
		
		String [] animals = {
			"cow"	,
			"sheep" , 
			"chicken",
			"cow",
			"sheep",
			"cow",
				
		};
		
		int count = 0;
		for(String word : animals){
		    if(word.equals(animal1)) {
		    	count++;
		    }else if(word.equals(animal2)) {
		    	count++;
		    }
		    
		}
		
		CountResponse reply = CountResponse.newBuilder().setResult(count).build();
		responseObserver.onNext(reply);

		responseObserver.onCompleted();
		
	}
	
	
	
	
	public void priceIncrease(AnimalRequest request,
			StreamObserver<AnimalResponse> responseObserver) {
		
		String animal = request.getAnimal();
		

		int price = request.getPrice();

		
	
		

		LiveStock stock1 = new LiveStock("chicken",300);
		LiveStock stock2 = new LiveStock("chicken",400);
		LiveStock stock3= new LiveStock("sheep",200);
		LiveStock stock4 = new LiveStock("sheep",300);
	
		
		ArrayList<LiveStock> LiveStock = new ArrayList<LiveStock>();
		LiveStock.add(stock1);
		LiveStock.add(stock2);
		LiveStock.add(stock3);
		LiveStock.add(stock4);
		
	
		
		
		
		
		for(int i = 0; i<LiveStock.size();i++) {
			
			String  msg = "";
	
			
			
			if(animal.equals(LiveStock.get(i).getAnimal())) {
				
				 int newPrice = LiveStock.get(i).getPrice()+price;
				 LiveStock.get(i).setPrice(newPrice);
				 
				 
		
		
				
				msg +="the new price of  of item is " + LiveStock.get(i).toString();
				
			}
			
			AnimalResponse reply = AnimalResponse.newBuilder().setMessage(msg).build();
			responseObserver.onNext(reply);
			
			try {
				//wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	
		responseObserver.onCompleted();
		

	}

}
