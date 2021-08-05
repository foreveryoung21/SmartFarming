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
			
			// the response from the server for the maximum weight and animal
			@Override
			public void onNext(WeightResponse value) {

				System.out.println("the maximum weight is"+value.getWeight()+value.getName());

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			// when the reply to the client has been complete
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("server completed maximum weight calculated");
			}



		};

		//
		StreamObserver<WeightRequest> requestObserver = asyncStub.maxWeight(responseObserver);

		try {
			
			// stream of inputs for animal types to find the maximum weight of  all the three
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
		
	// Builds a request 
	AnimalRequest request = AnimalRequest.newBuilder().setAnimal("chicken").setPrice(100).build();
	try {
		
		
		Iterator<AnimalResponse> responces = blockingStub.priceIncrease(request);
		
		// Prints message as long as the Animal Response has a response for the client

		while(responces.hasNext()) {
			AnimalResponse reply = responces.next();
			System.out.println("the animal is" +reply.getMessage()+" and the old price is "+reply.getOld() +
					"the new price is "+reply.getNew());				
		}

	} catch (StatusRuntimeException e) {
		e.printStackTrace();
	}
		
	}


	

	private static void animalCount() {
		
		String animal1 = "cow";
		String animal2 = "chicken";
		
	
	// A request is built to count the animal types entered 
		
	CountRequest request = CountRequest.newBuilder().setAnimal1(animal1).setAnimal2(animal2).build();
	
	// the animaCount method is invoked from server with request using blocking stub.
	CountResponse response  = blockingStub.animalCount(request);
	
	// the response is printed to the user
	System.out.println("The animal count is   " + response.getResult());

	}
	
	
	public static void areaLand() {


		StreamObserver<AreaResponse> responseObserver = new StreamObserver<AreaResponse>() {

			
	// the response of the filed name and calculated acres is returned to user 

			@Override
			public void onNext(AreaResponse msg) {
				
				
				System.out.println("the name of the field is " + msg.getField() + " the calculate acres are "+ msg.getAcres() );
			
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

	// shows when the response to the client is completed 
			@Override
			public void onCompleted() {
				System.out.println("stream is completed ... area of in acres calculated");
			}

		};



		StreamObserver<AreaRequest> requestObserver = asyncStub.areaLand(responseObserver);

		try {

		
			// stream on inputs for the field name and dimensions of width in feed and length in feet
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
