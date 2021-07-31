package com.smartfarming.farm;


import java.util.Iterator;
import java.util.Random;


import com.smartfarming.farm.Request;
import com.smartfarming.farm.CalculateResponse;
import com.smartfarming.farm.FarmServiceGrpc;
import com.smartfarming.farm.FarmServiceGrpc.FarmServiceBlockingStub;
import com.smartfarming.farm.FarmServiceGrpc.FarmServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class FarmClient {
	
	private static FarmServiceBlockingStub blockingStub;
	private static FarmServiceStub asyncStub;


	public static void main(String[] args) {

		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50052)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = FarmServiceGrpc.newBlockingStub(channel);

		asyncStub = FarmServiceGrpc.newStub(channel);


		
		calculate();
		
		
	
	}


	//unary rpc
	public static void calculate() {
		String day = "Monday";

		Request req = Request.newBuilder().setDay(day).build();

		CalculateResponse response = blockingStub.calculate(req);

		System.out.println("temperature is  " + response.getResult());
	}

	






	


}