package com.smartfarming.farm2;

import java.io.IOException;
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

}
