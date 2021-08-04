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

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
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
		discoverMathService(farm2_service_type);
		
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

	
	
	private void discoverMathService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Math Service resolved: " + event.getInfo());

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
					System.out.println("Math Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Math Service added: " + event.getInfo());

					
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
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
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
		
		
		
		
		
	
	
		
		JButton btnCalculate = new JButton("Count");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String animal1 = textNumber1.getText();
				String animal2 = textNumber2.getText();
				
			CountRequest request = CountRequest.newBuilder().setAnimal1(animal1).setAnimal2(animal2).build();
			CountResponse response  = blockingStub.animalCount(request);
			
			System.out.println("The animal count is   " + response.getResult());
			textResponse.append("The animal count is "+ response.getResult() + "\n");

			}
		});
		panel_service_1.add(btnCalculate);
		
		textResponse = new JTextArea(3, 20);
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
		
		
		
		
		
	}

}
