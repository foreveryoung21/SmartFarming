package com.smartfarming.farm2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.lang.Math;
import java.net.InetAddress;

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
		
		Properties prop = farmserver.getProperties();
		farmserver.registerService(prop);
		int port = Integer.valueOf(prop.getProperty("service_port") );
		
		 
		   
	    
	    Server server = ServerBuilder.forPort(port)
	        .addService(farmserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
		
	}
	
	
	private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/farm2.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Math Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	
	private  void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example";
	           // int service_port = 1234;
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
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
			
			
			int oldPrice = LiveStock.get(i).getPrice();
		
			
	
			
			
			if(animal.equals(LiveStock.get(i).getAnimal())) {
				
				 int newPrice = LiveStock.get(i).getPrice()+price;
				 LiveStock.get(i).setPrice(newPrice);
				 
				 
		
		
				
				
		
			}
			
			
			AnimalResponse reply = AnimalResponse.newBuilder().setNew(LiveStock.get(i).getPrice()).setOld(oldPrice).setMessage(LiveStock.get(i).getAnimal()).build();
		
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
				
				String msg ="";
				
				
				Animal maximum =null;
				
				int max =animals[0].weight;
				
			    for (int i=0; i<animals.length; i++) {
			        if (animals[i].getWeight() > max) {
			        	
			        	maximum=animals[i];
			        	
			              // new maximum
			        }
			    }
			  
		
			   
				WeightResponse reply = WeightResponse.newBuilder().setName(maximum.getAnimal()).setWeight(maximum.getWeight()).build();
			  
		            
		      
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
