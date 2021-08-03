package com.smartfarming.farm2;

import java.util.Iterator;
import java.util.Random;

import com.smartfarming.farm.PriceRequest;
import com.smartfarming.farm.PriceResponse;
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
	priceIncrease();
	maxWeight();
	areaLand();
	

	
		

	}




	

	





	private static void maxWeight() {
		
		StreamObserver<WeightResponse> responseObserver = new StreamObserver<WeightResponse>() {

			@Override
			public void onNext(WeightResponse value) {

				System.out.println(" "+ value.getMessage());

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("server completed");
			}



		};

		//
		StreamObserver<WeightRequest> requestObserver = asyncStub.maxWeight(responseObserver);

		try {

			requestObserver.onNext(WeightRequest.newBuilder().setAnimal1("lamb").build());
			requestObserver.onNext(WeightRequest.newBuilder().setAnimal2("cow").build());
			requestObserver.onNext(WeightRequest.newBuilder().setAnimal3("ox").build());
		
			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(10000);


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

		
	
	}












	private static void priceIncrease() {
	AnimalRequest request = AnimalRequest.newBuilder().setAnimal("sheep").setPrice(100).build();
	try {
		Iterator<AnimalResponse> responces = blockingStub.priceIncrease(request);

		while(responces.hasNext()) {
			AnimalResponse reply = responces.next();
			System.out.println(reply.getMessage());				
		}

	} catch (StatusRuntimeException e) {
		e.printStackTrace();
	}
		
	}


	

	private static void animalCount() {
		
		String animal1 = "cow";
		String animal2 = "chicken";
		
	CountRequest request = CountRequest.newBuilder().setAnimal1(animal1).setAnimal2(animal2).build();
	CountResponse response  = blockingStub.animalCount(request);
	
	System.out.println("The animal count is   " + response.getResult());

	}
	
	
	public static void areaLand() {


		StreamObserver<AreaResponse> responseObserver = new StreamObserver<AreaResponse>() {

			int count =0 ;

			@Override
			public void onNext(AreaResponse msg) {
				System.out.println("the name of the field is " + msg.getField() + " the calculate acres are "+ msg.getAcres() );
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... received "+ count+ " converted numbers");
			}

		};



		StreamObserver<AreaRequest> requestObserver = asyncStub.areaLand(responseObserver);

		try {

			requestObserver.onNext(AreaRequest.newBuilder().setField("field1").setWidthFeet(10000).setLengtFeet(10000).build());
			requestObserver.onNext(AreaRequest.newBuilder().setField("field2").setWidthFeet(20000).setLengtFeet(20000).build());
			requestObserver.onNext(AreaRequest.newBuilder().setField("field3").setWidthFeet(30000).setLengtFeet(20000).build());
			


			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}



		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

	
	

}
