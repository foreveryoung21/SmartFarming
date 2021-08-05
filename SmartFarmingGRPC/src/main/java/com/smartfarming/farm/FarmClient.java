package com.smartfarming.farm;


import java.util.Iterator;
import java.util.Random;








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
		
		
		
		

		//unary
		calculate();
		//server
		level();
		//client streaming
		totalPrice();
		//birectional
		irrigation();
	
		
	
	}




	















	private static void totalPrice() {
		// TODO Auto-generated method stub
		
		StreamObserver<PriceResponse> responseObserver = new StreamObserver<PriceResponse>() {
			
			// response to the client with the total value 
			@Override
			public void onNext(PriceResponse value) {

				System.out.println("the total price is " + value.getResult());

			}

			// an error if theres an issue with the response 
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			// message is printed out when the response is complete 
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("server completed and total price calculated");
			}



		};

		//
		StreamObserver<PriceRequest> requestObserver = asyncStub.totalPrice(responseObserver);

		try {
			// amimal types for the prices to be calculted
			requestObserver.onNext(PriceRequest.newBuilder().setAnimal1("cow").build());
			requestObserver.onNext(PriceRequest.newBuilder().setAnimal2("sheep").build());
			requestObserver.onNext(PriceRequest.newBuilder().setAnimal3("chicken").build());
		
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





















	private static void level() {
		
		// builds the request for setting the minimum and maximum level of the tank
		WaterRequest request = WaterRequest.newBuilder().setMin(100).setMax(1000).build();

		try {
			Iterator<WaterResponse> responces = blockingStub.level(request);

			// Prints message as long as the WaterResponse has a response for the client
			while(responces.hasNext()) {
				WaterResponse reply = responces.next();
				System.out.println(reply.getMessage());				
			}

		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
		
		
	}





	//unary rpc
	public static void calculate() {
		String day = "Monday";
		
		// The request is built and the day is set
		Request req = Request.newBuilder().setDay(day).build();
		
		// the calculate method is invoked from server with request using blocking stub.
		CalculateResponse response = blockingStub.calculate(req);
		
		// the result of the temperature is displayed to the user.
		System.out.println("temperature is  " + response.getResult());
		
		
	}

	
	
	
	public static void irrigation() {


		StreamObserver<SwitchResponse> responseObserver = new StreamObserver<SwitchResponse>() {

			

			@Override
			
			// response to the client request which has the sensor name with the new status and updated status
			public void onNext(SwitchResponse msg) {
				System.out.println("the sensor name is " + msg.getResponse() + " " + msg.getStatus() +" "
						+" the previos status was "+msg.getPrevious());
			}

			// will show an error is there is a issue with the response
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}
			
			
			// shows message when the request has been complete
			@Override
			public void onCompleted() {
				System.out.println("stream is completed  sensors status updated");
			}

		};



		StreamObserver<SwitchRequest> requestObserver = asyncStub.irrigation(responseObserver);

		try {
			
			// streamig of request sent to server with name of sensor and status
			requestObserver.onNext(SwitchRequest.newBuilder().setSensor("s1").setStatus("on").build());
			requestObserver.onNext(SwitchRequest.newBuilder().setSensor("s2").setStatus("off").build());
			requestObserver.onNext(SwitchRequest.newBuilder().setSensor("s3").setStatus("on").build());
	
		


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