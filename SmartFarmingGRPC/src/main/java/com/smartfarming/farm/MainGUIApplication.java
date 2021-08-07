package com.smartfarming.farm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.smartfarming.farm.FarmGrpc.FarmBlockingStub;
import com.smartfarming.farm.FarmServiceGrpc.FarmServiceBlockingStub;
import com.smartfarming.farm.FarmServiceGrpc.FarmServiceStub;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


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

	private static FarmServiceBlockingStub blockingStub;
	private static FarmServiceStub asyncStub;

	private ServiceInfo farmServiceInfo;
	
	
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
		
		String farm_service_type = "_farm._tcp.local.";
		discoverFarmService(farm_service_type);
		
		String host = farmServiceInfo.getHostAddresses()[0];
		int port = farmServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = FarmServiceGrpc.newBlockingStub(channel);

		asyncStub = FarmServiceGrpc.newStub(channel);

		
		initialize();
		
	}

	
	
	private void discoverFarmService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Farm Service resolved: " + event.getInfo());

					farmServiceInfo = event.getInfo();

					int port = farmServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + farmServiceInfo.getNiceTextString());
					System.out.println("\t host: " + farmServiceInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Farm Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Farm Service added: " + event.getInfo());

					
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
		
		JLabel lblNewLabel_1 = new JLabel("Day name");
		panel_service_1.add(lblNewLabel_1);
		
		textNumber1 = new JTextField();
		panel_service_1.add(textNumber1);
		textNumber1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Set Min");
		panel_service_1.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Set Max");
		panel_service_1.add(lblNewLabel_3);
		
		textNumber3= new JTextField();
		panel_service_1.add(textNumber3);
		textNumber3.setColumns(10);
		
		JLabel lblNewLabel_4= new JLabel("animal 1");
		panel_service_1.add(lblNewLabel_4);
		
		textNumber4= new JTextField();
		panel_service_1.add(textNumber4);
		textNumber4.setColumns(10);
		
		
		JLabel lblNewLabel_5= new JLabel("animal 2");
		panel_service_1.add(lblNewLabel_5);
		
		textNumber5= new JTextField();
		panel_service_1.add(textNumber5);
		textNumber5.setColumns(10);
		
		JLabel lblNewLabel_6= new JLabel("animal 3");
		panel_service_1.add(lblNewLabel_6);
		
		textNumber6= new JTextField();
		panel_service_1.add(textNumber6);
		textNumber6.setColumns(10);
		
		
		JLabel lblNewLabel_7= new JLabel("Sensor name1");
		panel_service_1.add(lblNewLabel_7);
		
		textNumber7= new JTextField();
		panel_service_1.add(textNumber7);
		textNumber7.setColumns(10);
		
		
		JLabel lblNewLabel_8= new JLabel("Status 1");
		panel_service_1.add(lblNewLabel_8);
		
		textNumber8= new JTextField();
		panel_service_1.add(textNumber8);
		textNumber8.setColumns(10);
		
		JLabel lblNewLabel_9= new JLabel("Sensor name2");
		panel_service_1.add(lblNewLabel_9);
		
		textNumber9= new JTextField();
		panel_service_1.add(textNumber9);
		textNumber9.setColumns(10);
		
		JLabel lblNewLabel_10= new JLabel("Status 2");
		panel_service_1.add(lblNewLabel_10);
		
		textNumber10= new JTextField();
		panel_service_1.add(textNumber10);
		textNumber10.setColumns(10);
		
		JLabel lblNewLabel_11= new JLabel("Sensor name3");
		panel_service_1.add(lblNewLabel_11);
		
		textNumber11= new JTextField();
		panel_service_1.add(textNumber11);
		textNumber11.setColumns(10);
		
		
		JLabel lblNewLabel_12= new JLabel("Status 3");
		panel_service_1.add(lblNewLabel_12);
		
		textNumber12= new JTextField();
		panel_service_1.add(textNumber12);
		textNumber12.setColumns(10);
		
		
	
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String day  = textNumber1.getText();
				
				
				try {
					
			
					
					if((day.equals("monday")) || (day.equals("tuesday"))|| (day.equals("wednesday")) || (day.equals("thursday"))
							|| (day.equals("friday")) || (day.equals("saturday"))|| (day.equals("sunday"))  ) {
						
						Request req = Request.newBuilder().setDay(day).build();

						CalculateResponse response = blockingStub.calculate(req);

						System.out.println("temperature is  " + response.getResult());

						textResponse.append("temperature is:"+ response.getResult() + "\n");
						
						System.out.println("result temperature " + response.getResult()  );
						
			
			
						
						
						
					}else {
						
						throw new Exception ("incorrect day entered "+"\n");
						
					
					}
					}
					catch(Exception ex) {
						textResponse.append("incorrect day entered !"+"\n");
						System.out.println("incorrect day entered !");
					}
			

				
				
			
				

			}
		});
		panel_service_1.add(btnCalculate);
		
		textResponse = new JTextArea(4, 40);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		
		
		
		JButton btnLevel = new JButton("Find");
		btnLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int min = Integer.parseInt(textNumber2.getText());
				int max = Integer.parseInt(textNumber3.getText());
				
				
				
				
				WaterRequest request = WaterRequest.newBuilder().setMin(min).setMax(max).build();
				
				
				
				try {
					
					if(min>=100 && max<=1000) {
						
					
						Iterator<WaterResponse> responces = blockingStub.level(request);

						while(responces.hasNext()) {
							WaterResponse reply = responces.next();
							System.out.println(reply.getMessage());		
							textResponse.append("water level :"+ reply.getMessage() + "\n");
						}

						
						
					}else {
						
						throw new Exception ("min has to be above 100 and  below max 1000  "+"\n");
						
					}
					
			
				} catch (StatusRuntimeException ex) {
					ex.printStackTrace();
				}
				catch (Exception ex) {
					
					textResponse.append("min has to be above 100 and  below max 1000   !"+"\n");
					System.out.println("min has to be above 100 and  below max 1000 !");
				
				}
			
				

			}
		});
		panel_service_1.add(btnLevel);
		
		
		
		
		JButton btnPrice = new JButton("Total");
		btnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String animal1  = textNumber4.getText();
				String animal2  = textNumber5.getText();
				String animal3  = textNumber6.getText();
				
			

				StreamObserver<PriceResponse> responseObserver = new StreamObserver<PriceResponse>() {

					@Override
					public void onNext(PriceResponse value) {
					
						
						
						try {
							
							if(((animal1.equals( "cow")) || (animal1.equals("chicken"))|| (animal1.equals("sheep")))
							 && ((animal2.equals("cow")) || (animal2.equals("chicken")) || (animal2.equals("sheep")))
							 && ((animal3.equals("cow")) || (animal3.equals("chicken")) || (animal3.equals("sheep")))
									) {
								
								System.out.println("the total price is " + value.getResult());
								textResponse.append("the total price is:"+ value.getResult() + "\n");
								
							}else {
								throw new Exception ("invalid animal has to be sheep, chicken , cow  "+"\n");
							}   
							  //  Block of code to try
							}
							catch(Exception e) {
								textResponse.append("invalid animal has to be sheep, chicken , cow "+ "\n");
							}
						
						

					

					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("server completed total price calculated");
					}



				};

				//
				StreamObserver<PriceRequest> requestObserver = asyncStub.totalPrice(responseObserver);

				try {

					requestObserver.onNext(PriceRequest.newBuilder().setAnimal1(animal1).build());
					requestObserver.onNext(PriceRequest.newBuilder().setAnimal2(animal2).build());
					requestObserver.onNext(PriceRequest.newBuilder().setAnimal3(animal3).build());
				
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
		panel_service_1.add(btnPrice);
		
		
		JButton btnSwitch = new JButton("Switch");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sensorName1  = textNumber7.getText();
				String sensorName2  = textNumber9.getText();
				String sensorName3  = textNumber11.getText();
				
				String status1 = textNumber8.getText();
				String status2  = textNumber10.getText();
				String status3  = textNumber12.getText();
				
				
				
				
				
				StreamObserver<SwitchResponse> responseObserver = new StreamObserver<SwitchResponse>() {


					@Override
					public void onNext(SwitchResponse msg) {
						
						try {
							
							if(((status1.equals( "off")) || (status1.equals("on"))) &&
							( (status2.equals("off")) || (status2.equals("on")) )
									 && ((status3.equals("off")) || (status3.equals("on")) )
											) {
										
								System.out.println("the sensor name is " + msg.getResponse() + " " + msg.getStatus() +" "
										+" the previous status was "+msg.getPrevious());
								textResponse.append("the sensor name is:"+ msg.getResponse()+ ""+ msg.getStatus()+" "+
										"the previous status was "+ msg.getPrevious()
								+ "\n");
										
									}else {
										throw new Exception ("invalid status entered check status field  "+"\n");
									}
							
						
							}
							catch(Exception e) {
								System.out.println("invalid status entered check status field  "+"\n");
								textResponse.append("invalid status entered check status field  "+"\n");
							}
						
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println("stream is completed ...sensor statutes updated");
					}

				};



				StreamObserver<SwitchRequest> requestObserver = asyncStub.irrigation(responseObserver);

				try {

					requestObserver.onNext(SwitchRequest.newBuilder().setSensor(sensorName1).setStatus(status1).build());
					requestObserver.onNext(SwitchRequest.newBuilder().setSensor(sensorName2).setStatus(status2).build());
					requestObserver.onNext(SwitchRequest.newBuilder().setSensor(sensorName3).setStatus(status3).build());
			
				


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
		panel_service_1.add(btnSwitch);
		
		
	
	}
	
	
	
	
	

}
