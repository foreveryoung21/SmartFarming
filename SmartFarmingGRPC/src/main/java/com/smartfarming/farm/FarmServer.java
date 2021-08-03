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
		
		
		
		
		public void calculate(Request request, 
				StreamObserver<CalculateResponse> responseObserver) {
			
			String day = request.getDay().toLowerCase();
			int temp = temperature(day);
			
			

			CalculateResponse reply = CalculateResponse.newBuilder().setResult(temp).build();
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



public StreamObserver<PriceRequest> totalPrice(StreamObserver<PriceResponse> responseObserver) {
	return new StreamObserver<PriceRequest>() {

		@Override
		public void onNext(PriceRequest request) {
			String animal1 =request.getAnimal1();
			String animal2 =request.getAnimal2();
			String  animal3 =request.getAnimal3();
			
			int cow = 2000;
			int sheep = 2000;
			int chicken = 2200;
			
			
			    
			int [] animals = {cow,sheep,chicken};
			
			int sum = 0;
			
			for(int i =0;i<animals.length;i++) {
				
				if(animal1.equals("cow")){
					sum =sum + animals[i];
				}else if(animal2.equals("sheep")) {
					sum =sum+animals[i];
				}else if(animal3.equals("chicken")) {
					sum =sum+animals[i];
				}
			}
			
			
			
			
			
	        
	            PriceResponse reply = PriceResponse.newBuilder().setResult(sum).build();
	      
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





public StreamObserver<SwitchRequest> irrigation(StreamObserver<SwitchResponse> responseObserver) {
	
	return new StreamObserver<SwitchRequest> () {

		@Override
		public void onNext(SwitchRequest msg) {
	
			
	
			
			String name = msg.getSensor1();
			String name2 = msg.getSensor2();
			String name3 = msg.getSensor2();
			
			String stat1 = msg.getStatus1();
			String stat2 = msg.getStatus1();
			String stat3 = msg.getStatus1();
			
	
			
			
			
			Sensor sensorOne = new Sensor("s1","on");
			Sensor sensorTwo = new Sensor("s2","off");
			Sensor sensorThree = new Sensor("s3","on");
			
			
			if(name.equals(sensorOne.getSensor())) {
				
				if(stat1.equals("on") && sensorOne.getStatus().equals("off")) {
					sensorOne.setStatus("on");
					
				}else {
					sensorOne.setStatus("off");
				}
				
			}else if(name2.equals(sensorTwo.getSensor())) {
				
				if(stat2.equals("on") && sensorTwo.getStatus().equals("off")) {
					sensorTwo.setStatus("on");
					
				}else {
					sensorOne.setStatus("off");
				}
				
			}
             else if(name3.equals(sensorTwo.getSensor())) {
				
				if(stat3.equals("on") && sensorThree.getStatus().equals("off")) {
					sensorThree.setStatus("on");
					
				}else {
					sensorOne.setStatus("off");
				}
				
			}
			
			
           
			
			
			
	
			String sensors = sensorOne.toString()+sensorTwo.toString()+sensorThree.toString();
			
		
			
			
		
			
			
				
			SwitchResponse reply =  SwitchResponse.newBuilder().setResponse(sensors).build();
				
				
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
