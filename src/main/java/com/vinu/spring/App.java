package com.vinu.spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vinu.spring.controller.BikeController;
import com.vinu.spring.entity.Bike;

@Configuration
@ComponentScan(basePackages = { "com.vinu.spring" })
public class App {
	@Autowired
	private BikeController bikeController;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
		App app = applicationContext.getBean(App.class);

		System.out.println("Enter 1 => getAll \nEnter 2 => delete by id \nEnter 3 => getById \n"
				+ "Enter 4 => saveOneRecord \nEnter 5 => updateById");
		int value = sc.nextInt();

		switch (value) {
		case 1:
			List<Bike> bike = app.bikeController.getAll();
			for (Bike b : bike) {
				System.out.println(b.getBikeId() + " => " + b.getBikeName() + " => " +b.getBikePrice());
			}
			break;

		case 2:
			System.out.println("Enter id");
			int id = sc.nextInt();
			String message1 = app.bikeController.deleteByid(id);
			System.out.println(message1);
			break;

		case 3:
			System.out.println("Enter id");
			int id1 = sc.nextInt();
			Bike b = app.bikeController.getById(id1);
			System.out.println(b.getBikeId() + " => " + b.getBikeName() + " => " +b.getBikePrice());
			break;

		case 4:
			System.out.println("Enter bike id");
			int bikeId = sc.nextInt();
			System.out.println("Enter bike Name");
			String bikeName = sc.next();		
			System.out.println("Enter bike price");
			int bikePrice = sc.nextInt();
			String message3 = app.bikeController.saveBike(bikeId, bikeName, bikePrice);
			System.out.println(message3);
			break;

		case 5:
			System.out.println("Enter bike id");
			int bikeId1 = sc.nextInt();
			System.out.println("Enter bike Name");
			String bikeName1 = sc.next();
			System.out.println("Enter bike price");
			int bikePrice1 = sc.nextInt();
			String message4 = app.bikeController.updateById(bikeId1, bikeName1, bikePrice1);
			System.out.println(message4);
			break;

		default:System.out.println("Invalid Selection");
			break;
		}
		sc.close();
	}
}
