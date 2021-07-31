package com.smartfarming.farm;


import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;
import java.lang.Math;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import com.smartfarming.farm.FarmServiceGrpc.FarmServiceImplBase;
import com.smartfarming.farm.Request;
import com.smartfarming.farm.CalculateResponse;

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

	
	
}
