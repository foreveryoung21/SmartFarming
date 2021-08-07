package com.smartfarming.farm;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.smartfarming.farm.FarmServiceGrpc.FarmServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class FarmServer extends FarmServiceImplBase {


	private static final Logger logger = Logger.getLogger(FarmServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		 FarmServer farmserver = new FarmServer();
		 
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
			
			 try (InputStream input = new FileInputStream("src/main/resources/farm.properties")) {

		            prop = new Properties();

		            // load a properties file
		            prop.load(input);

		            // get the property value and print it out
		            System.out.println("Farm Service properies ...");
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
		
		
		
		
		public void calculate(Request request, 
				StreamObserver<CalculateResponse> responseObserver) {
			// The request from client is converted cause the days are in lowercase 
			// The day request from the client is converted to lower case and stored in day
			
			String day = request.getDay().toLowerCase();
			
			
			
			
			// The day is used for the function temperature which will be used to calculate temperature
			int temp = temperature(day);
			
			
			// The reponse is bult that contains the caculated temperature
			CalculateResponse reply = CalculateResponse.newBuilder().setResult(temp).build();
			// Using the reponseObserver we can send the response to the client
			responseObserver.onNext(reply);
			
			// Using the reponseObserver we can send the response to the client
			responseObserver.onCompleted();
		}
		
		
		




	// the function uses switch statements to determine the temperature 
private int temperature(String day) {
	int temp = 0;
	switch (day) {
	  case "monday":
	    temp =(int)(Math.random() * 31)+1;
	    break;
	  case "tuesday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	  case "wednesday":
		temp =(int)(Math.random() * 31)+1;
	    break;
	  case "thursday":
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


	// generate numbers for random tank levels and using request from client to generate highest number 

	int tank1 =(int)(Math.random() * request.getMax())+1;
	int tank2 =(int)(Math.random() * request.getMax())+1;
	int tank3 =(int)(Math.random() * request.getMax())+1;
	
	
	int [] tanks = {tank1,tank2,tank3};
	
	// the loop which will check the tank  level exceed or below the min
	// it prints the related message according to the check against min and max
	
	for(int i=0 ; i<tanks.length;i++) {
		String msg ="";
		if(tanks[i]>request.getMax()) {
			msg =tanks[i]+"tank is above water level";
			
			
		}else if(tanks[i]<request.getMin()) {
			msg =tanks[i]+" tank is below water level";
	
			

			
		}else {
			msg =tanks[i]+" tank is at a coorrect level";
			
			
			
		}
		
	// builds the reponse in relation to the level of the tank 
		WaterResponse reply = WaterResponse.newBuilder().setMessage(msg).build();
 //  sends the leve of the tank to the client 
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



public StreamObserver<PriceRequest> totalPrice(StreamObserver<PriceResponse> responseObserver) {
	return new StreamObserver<PriceRequest>() {

		@Override
		public void onNext(PriceRequest request) {
			
			// the animal types from the user 
			String animal1 =request.getAnimal1();
			String animal2 =request.getAnimal2();
			String  animal3 =request.getAnimal3();
			
			
			
			String [] animals = {animal1,animal2,animal3};
			    

			
			int total = 0;
			
	
			// the loop will check the animal type and add according to the type of animal
			
			for(int i =0; i<animals.length;i++) {
				
				if(animals[i].equals("cow")) {
					total +=(int)(Math.random() * 999+1);
			
					
				}else if(animals[i].equals("sheep")) {
					total+=(int)(Math.random() * 999+1);
				
				}else if(animals[i].equals("chicken")) {
					total +=(int)(Math.random() * 999+1);
					
				}
				
				
			}
			
			
			
			
			
	        // the totla is then built with the response to the client
	            PriceResponse reply = PriceResponse.newBuilder().setResult(total).build();
	         // Using the reponseObserver we can send the response to the client
	            responseObserver.onNext(reply);
			
		}

		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stubal
			
		}
		
		
		// when the response is completed 
		@Override
		public void onCompleted() {
			 responseObserver.onCompleted();
			
		}
		
	};
}





public StreamObserver<SwitchRequest> irrigation(StreamObserver<SwitchResponse> responseObserver) {
	
	return new StreamObserver<SwitchRequest> () {

		@Override
		public void onNext(SwitchRequest msg) {
	
			

		// the senosr name and status is recieved from the client 
			String name = msg.getSensor();
			
			
			String stat = msg.getStatus();
		
		// the random is used to generated index number of 0-1 for options array 
			int random =(int)(Math.random() *1+0.5);
			
			String [] option = {"off","on"};
			
	   // the sensor object is created with random status 
			Sensor sensor = new Sensor(option[random]);
			
		
	  // the previous status of the sensor
			
			String prevstatus = sensor.getStatus();
			
	
			
			
		
		// checks the status against the user input and sets the status accourding to check	
				if(stat.equals("on") && sensor.getStatus().equals("on")) {
					sensor.setStatus("on");
					
				}else {
					sensor.setStatus("off");
				}
				
				
			// Response for the client is built with the name of sensor and statuses
				SwitchResponse reply = SwitchResponse.newBuilder().setResponse(name).setStatus(sensor.toString()).setStatus(sensor.getStatus())
						.setPrevious(prevstatus).build();
				// Using the reponseObserver we can send the response to the client	
			responseObserver.onNext(reply);
				
	
			
			
		}

		@Override
		public void onError(Throwable t) {
			
			t.printStackTrace();
			
		}

		@Override
		public void onCompleted() {
			System.out.println("receiving updated sensor statuses completed ");
			
			//when the response is completed
			responseObserver.onCompleted();
		}
		
	};
}





}
