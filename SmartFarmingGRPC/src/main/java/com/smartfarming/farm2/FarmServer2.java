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
import com.smartfarming.farm.PriceRequest;
import com.smartfarming.farm.PriceResponse;
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
	
	
	public StreamObserver<WeightRequest> maxWeight(StreamObserver<WeightResponse> responseObserver) {
		return new StreamObserver<WeightRequest>() {

			@Override
			public void onNext(WeightRequest request) {
				String animal1 =request.getAnimal1();
				String animal2 =request.getAnimal2();
				String  animal3 =request.getAnimal3();
				
				int weight1 =(int)(Math.random() * 99+1);
				int weight2 =(int)(Math.random() * 99+1);
				int weight3 =(int)(Math.random() * 99+1);
				
				Animal animalOne= new Animal(animal1,weight1);
				Animal animalTwo= new Animal(animal2,weight2);
				Animal animalThree= new Animal(animal3,weight3);
				
			
				
				    
				Animal [] animals = {animalOne,animalTwo,animalThree};
				
				
				int  max =-1;
				int index =-1;
				
			    for (int i=0; i<animals.length; i++) {
			        if (animals[i].getWeight() > max) {
			        	
			        	index=i;
			        	
			              // new maximum
			        }
			    }
			  
			    
			    Animal maximum = animals[index];
				
				
		        
		            WeightResponse reply = WeightResponse.newBuilder().setMessage(maximum.toString()).build();
		      
		            responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stubal
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
			
		};
	}
	
	
	
public StreamObserver<AreaRequest> areaLand(StreamObserver<AreaResponse> responseObserver) {
		
		return new StreamObserver<AreaRequest> () {

			@Override
			public void onNext(AreaRequest msg) {
				
				System.out.println("receiving convertBase method num: "+ msg.getField() + " from-base: "+ msg.getWidthFeet() + " to-base: "+ msg.getWidthFeet()  );
				
				String field = msg.getField();
				int width = msg.getWidthFeet();
				int length = msg.getWidthFeet();
				int oneAcre = 43560;
				
				int squarefeet=  width *length;
				int acres = squarefeet/oneAcre;
				
				AreaResponse reply = AreaResponse.newBuilder().setAcres(acres).setField(field).build();
				
				responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println("receiving convertBase completed ");
				
				//completed too
				responseObserver.onCompleted();
			}
			
		};
	}
	


}
