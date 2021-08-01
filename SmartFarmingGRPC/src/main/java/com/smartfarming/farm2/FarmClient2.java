package com.smartfarming.farm2;

import java.util.Iterator;
import java.util.Random;


import com.smartfarming.farm.FarmServiceGrpc;
import com.smartfarming.farm.FarmServiceGrpc.FarmServiceBlockingStub;
import com.smartfarming.farm.FarmServiceGrpc.FarmServiceStub;
import com.smartfarming.farm2.FarmService2Grpc.FarmService2BlockingStub;
import com.smartfarming.farm2.FarmService2Grpc.FarmService2Stub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class FarmClient2 {
	private static FarmService2BlockingStub blockingStub;
	private static FarmService2Stub  asyncStub;

	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50054)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = FarmService2Grpc.newBlockingStub(channel);

		asyncStub = FarmService2Grpc.newStub(channel);
		
		
		
		

		
	animalCount();
		

	}

	private static void animalCount() {
		
		String animal1 = "cow";
		String animal2 = "chicken";
		
	CountRequest request = CountRequest.newBuilder().setAnimal1(animal1).setAnimal2(animal2).build();
	CountResponse response  = blockingStub.animalCount(request);
	
	System.out.println("The animal count is   " + response.getResult());

	}

}
