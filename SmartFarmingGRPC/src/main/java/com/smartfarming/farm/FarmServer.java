package com.smartfarming.farm;


import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Logger;
import java.lang.Math;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import com.smartfarming.farm.FarmServiceGrpc.FarmServiceImplBase;



import com.smartfarming.farm.Request;
import com.smartfarming.farm.CalculateResponse;
import com.smartfarming.farm.WaterRequest;
import com.smartfarming.farm.WaterResponse;

import io.grpc.stub.StreamObserver;


public class FarmServer extends FarmServiceImplBase {


	private static final Logger logger = Logger.getLogger(FarmServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		 FarmServer farmserver = new FarmServer();
		   
		    int port = 50052;
		    Server server = ServerBuilder.forPort(port)
		        .addService(farmserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }

	
		public void calculate(Request request, 
				StreamObserver<CalculateResponse> responseObserver) {
			
			String day = request.getDay().toLowerCase();
			int temp = temperature(day);
			
			

			CalculateResponse reply = CalculateResponse.newBuilder().setResult(temp).build();
			responseObserver.onNext(reply);

			responseObserver.onCompleted();
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


	
private int temperature(String day) {
	int temp = 0;
	switch (day) {
	  case "monday":
	    temp =(int)(Math.random() * 31)+1;
	    break;
	  case "tueday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	  case "wednesday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	  case "thurday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	  case "friday":
	    temp =(int)(Math.random() * 31)+1;
	    break;
	  case "saturday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	  case "sunday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	}
	
	
	
	return temp;
	
}


public void level(WaterRequest request,
		StreamObserver<WaterResponse> responseObserver) {



	int tank1 =(int)(Math.random() * request.getMax())+1;
	int tank2 =(int)(Math.random() * request.getMax())+1;
	int tank3 =(int)(Math.random() * request.getMax())+1;
	
	
	int [] tanks = {tank1,tank2,tank3};
	
	
	for(int i=0 ; i<tanks.length;i++) {
		String msg ="";
		if(tanks[i]>request.getMax()) {
			msg ="tank is above water level";
			
			
		}else if(tanks[i]<request.getMin()) {
			msg ="tank is below water level";
	
			

			
		}else {
			msg ="tank is at a coorrect level";
			
			
			
		}
		WaterResponse reply = WaterResponse.newBuilder().setMessage(msg).build();
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
