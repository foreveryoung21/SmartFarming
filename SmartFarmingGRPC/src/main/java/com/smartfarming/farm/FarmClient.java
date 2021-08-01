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
	
		
	
	}




	
	private static void level() {
		WaterRequest request = WaterRequest.newBuilder()
				.setNumbers(5).setMin(0).setMax(100).build();

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

	
	
	
	
	// server streaming





	


}