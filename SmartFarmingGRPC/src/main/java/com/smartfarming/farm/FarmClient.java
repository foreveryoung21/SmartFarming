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
		
		
		
		

		
		calculate();
		level();
		totalPrice();
		irrigation();
	
		
	
	}




	















	private static void totalPrice() {
		// TODO Auto-generated method stub
		
		StreamObserver<PriceResponse> responseObserver = new StreamObserver<PriceResponse>() {

			@Override
			public void onNext(PriceResponse value) {

				System.out.println("the total price is " + value.getResult());

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
		StreamObserver<PriceRequest> requestObserver = asyncStub.totalPrice(responseObserver);

		try {

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
		WaterRequest request = WaterRequest.newBuilder().setMin(100).setMax(1000).build();

		try {
			Iterator<WaterResponse> responces = blockingStub.level(request);

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

		Request req = Request.newBuilder().setDay(day).build();

		CalculateResponse response = blockingStub.calculate(req);

		System.out.println("temperature is  " + response.getResult());
		
		
	}

	
	
	
	public static void irrigation() {


		StreamObserver<SwitchResponse> responseObserver = new StreamObserver<SwitchResponse>() {

			int count =0 ;

			@Override
			public void onNext(SwitchResponse msg) {
				System.out.println("the switch is  " + msg.getResponse() );
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



		StreamObserver<SwitchRequest> requestObserver = asyncStub.irrigation(responseObserver);

		try {

			requestObserver.onNext(SwitchRequest.newBuilder().setSensor1("s1").setStatus1("on").build());
			requestObserver.onNext(SwitchRequest.newBuilder().setSensor1("s2").setStatus1("off").build());
			requestObserver.onNext(SwitchRequest.newBuilder().setSensor1("s3").setStatus1("on").build());
	
		


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