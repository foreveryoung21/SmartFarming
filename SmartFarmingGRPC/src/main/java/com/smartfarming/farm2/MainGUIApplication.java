package com.smartfarming.farm2;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import com.smartfarming.farm2.FarmService2Grpc.FarmService2BlockingStub;
import com.smartfarming.farm2.FarmService2Grpc.FarmService2Stub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	private static FarmService2BlockingStub blockingStub;
	private static FarmService2Stub asyncStub;

	private ServiceInfo farm2ServiceInfo;
	
	
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JTextField textNumber3;
	private JTextField textNumber4;
	
	
	
	private JTextField textNumber5;
	private JTextField textNumber6;
	private JTextField textNumber7;
	private JTextField textNumber8;
	private JTextField textNumber9;
	private JTextField textNumber10;
	private JTextField textNumber11;
	private JTextField textNumber12;
	private JTextField textNumber13;
	
	
	private JTextField textNumber14;
	private JTextField textNumber15;
	private JTextField textNumber16;
	private JTextArea textResponse ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIApplication window = new MainGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUIApplication() {
		
		String farm2_service_type = "_farm2._tcp.local.";
		discoverFarmService2(farm2_service_type);
		
		String host = farm2ServiceInfo.getHostAddresses()[0];
		int port = farm2ServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = FarmService2Grpc.newBlockingStub(channel);

		asyncStub = FarmService2Grpc.newStub(channel);

		
		initialize();
	}

	
	
	private void discoverFarmService2(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Farm Service 2 resolved: " + event.getInfo());

					farm2ServiceInfo = event.getInfo();

					int port = farm2ServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + farm2ServiceInfo.getNiceTextString());
					System.out.println("\t host: " + farm2ServiceInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Farm Service 2 removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Farm Service 2 added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Animal 1");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Animal 2");
		panel_service_1.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Animal name ");
		panel_service_1.add(lblNewLabel_3);
		
		textNumber3 = new JTextField();
		panel_service_1.add(textNumber3);
		textNumber3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Set Price");
		panel_service_1.add(lblNewLabel_4);
		
		textNumber4 = new JTextField();
		panel_service_1.add(textNumber4);
		textNumber4.setColumns(10);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Field1");
		panel_service_1.add(lblNewLabel_5);
		
		textNumber5 = new JTextField();
		panel_service_1.add(textNumber5);
		textNumber5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Width Feet");
		panel_service_1.add(lblNewLabel_6);
		
		textNumber6 = new JTextField();
		panel_service_1.add(textNumber6);
		textNumber6.setColumns(10);
		
		
		JLabel lblNewLabel_7 = new JLabel("Length Feet");
		panel_service_1.add(lblNewLabel_7);
		
		textNumber7 = new JTextField();
		panel_service_1.add(textNumber7);
		textNumber7.setColumns(10);
		
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Field2");
		panel_service_1.add(lblNewLabel_8);
		
		textNumber8 = new JTextField();
		panel_service_1.add(textNumber8);
		textNumber8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Width Feet");
		panel_service_1.add(lblNewLabel_9);
		
		textNumber9 = new JTextField();
		panel_service_1.add(textNumber9);
		textNumber9.setColumns(10);
		
		
		JLabel lblNewLabel_10 = new JLabel("Length Feet");
		panel_service_1.add(lblNewLabel_10);
		
		textNumber10 = new JTextField();
		panel_service_1.add(textNumber10);
		textNumber10.setColumns(10);
	
		
		
		JLabel lblNewLabel_11 = new JLabel("Field3");
		panel_service_1.add(lblNewLabel_11);
		
		textNumber11 = new JTextField();
		panel_service_1.add(textNumber11);
		textNumber11.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Width Feet");
		panel_service_1.add(lblNewLabel_12);
		
		textNumber12 = new JTextField();
		panel_service_1.add(textNumber12);
		textNumber12.setColumns(10);
		
		
		JLabel lblNewLabel_13 = new JLabel("Length Feet");
		panel_service_1.add(lblNewLabel_13);
		
		textNumber13 = new JTextField();
		panel_service_1.add(textNumber13);
		textNumber13.setColumns(10);
		
		
		

		
		
		JLabel lblNewLabel_14 = new JLabel("Animal_1");
		panel_service_1.add(lblNewLabel_14);
		
		textNumber14 = new JTextField();
		panel_service_1.add(textNumber14);
		textNumber14.setColumns(10);
	
		
		
		JLabel lblNewLabel_15 = new JLabel("Animal_2");
		panel_service_1.add(lblNewLabel_15);
		
		textNumber15 = new JTextField();
		panel_service_1.add(textNumber15);
		textNumber15.setColumns(10);
	
		
		JLabel lblNewLabel_16 = new JLabel("Animal_3");
		panel_service_1.add(lblNewLabel_16);
		
		textNumber16 = new JTextField();
		panel_service_1.add(textNumber16);
		textNumber16.setColumns(10);
		
		
		
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String animal1 = textNumber1.getText();
				String animal2 = textNumber2.getText();
				
			CountRequest request = CountRequest.newBuilder().setAnimal1(animal1).setAnimal2(animal2).build();
			CountResponse response  = blockingStub.animalCount(request);
			
			System.out.println("The animal count is   " + response.getResult());
			textResponse.append("The animal count is "+ response.getResult() + "\n");

			}
		});
		panel_service_1.add(btnCount);
		
		textResponse = new JTextArea(5, 40);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		

		JButton btnIncrease = new JButton("Increase");
		btnIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String animal = textNumber3.getText();
				int increase = Integer.parseInt(textNumber4.getText());
				
				AnimalRequest request = AnimalRequest.newBuilder().setAnimal(animal).setPrice(increase).build();
				try {
					Iterator<AnimalResponse> responces = blockingStub.priceIncrease(request);

					while(responces.hasNext()) {
						AnimalResponse reply = responces.next();
						System.out.println("the animal is" +reply.getMessage()+" and the old price is "+reply.getOld() +
								"the new price is "+reply.getNew());	
						
						textResponse.append("the animal is" +reply.getMessage()+" and the old price is "+reply.getOld() +
								"the new price is "+reply.getNew()+"\n");
					}

				} catch (StatusRuntimeException ex) {
					ex.printStackTrace();
				}
					

				
				
				
				
				
				
				
				
		

			}
		});
		panel_service_1.add(btnIncrease);
		
		
		
		JButton btnAcres = new JButton("Acres");
		btnAcres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String field1 = textNumber5.getText();
				String field2 = textNumber8.getText();
				String field3 = textNumber11.getText();
				
				int width1 = Integer.parseInt(textNumber6.getText());
				int width2 = Integer.parseInt(textNumber9.getText());
				int width3 = Integer.parseInt(textNumber12.getText());
				
				
				int length1 = Integer.parseInt(textNumber7.getText());
				int length2 = Integer.parseInt(textNumber10.getText());
				int length3 = Integer.parseInt(textNumber13.getText());
				
				
				
		
				StreamObserver<AreaResponse> responseObserver = new StreamObserver<AreaResponse>() {

					int count =0 ;

					@Override
					public void onNext(AreaResponse msg) {
						System.out.println("the name of the field is " + msg.getField() + " the calculate acres are "+ msg.getAcres() );
						textResponse.append("the name of the field is " + msg.getField() + " the calculate acres are "+ msg.getAcres()+"\n");
						
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

					requestObserver.onNext(AreaRequest.newBuilder().setField(field1).setWidthFeet(width1).setLengtFeet(length1).build());
					requestObserver.onNext(AreaRequest.newBuilder().setField(field2).setWidthFeet(width2).setLengtFeet(length2).build());
					requestObserver.onNext(AreaRequest.newBuilder().setField(field3).setWidthFeet(width3).setLengtFeet(length3).build());
					


					// Mark the end of requests
					requestObserver.onCompleted();


					// Sleep for a bit before sending the next one.
					Thread.sleep(new Random().nextInt(1000) + 500);


				} catch (RuntimeException ex) {
					ex.printStackTrace();
				} catch (InterruptedException ex) {			
					ex.printStackTrace();
				}



				try {
					Thread.sleep(15000);
				} catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

				

				
				
				
				
				
				
				
				
		

			}
		});
		panel_service_1.add(btnAcres);
		
		JButton btnWeight = new JButton("Weight");
		btnWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String animal1 = textNumber14.getText();
				String animal2 = textNumber15.getText();
				String animal3 = textNumber16.getText();
				
				StreamObserver<WeightResponse> responseObserver = new StreamObserver<WeightResponse>() {

					@Override
					public void onNext(WeightResponse value) {

						System.out.println("the maximum weight is"+value.getWeight()+"animal"+value.getName());
						textResponse.append("the maximum weight is"+value.getWeight()+"animal"+value.getName());
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

					requestObserver.onNext(WeightRequest.newBuilder().setAnimal1(animal1).build());
					requestObserver.onNext(WeightRequest.newBuilder().setAnimal2(animal2).build());
					requestObserver.onNext(WeightRequest.newBuilder().setAnimal3(animal3).build());
				
					// Mark the end of requests
					requestObserver.onCompleted();


					// Sleep for a bit before sending the next one.
					Thread.sleep(10000);


				} catch (RuntimeException ex) {
					ex.printStackTrace();
				} catch (InterruptedException ex) {			
					ex.printStackTrace();
				}

			
				
				
		




		

				
				
				
				
				
				
				
				
		

			}
		});
		panel_service_1.add(btnWeight);
		
		
		
	}

}
