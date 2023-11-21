package com.vinu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vinu.spring.entity.Bike;
import com.vinu.spring.service.BikeService;

@Controller
public class BikeController 
{
	@Autowired
	private BikeService bikeService;
	
	public String saveBike(int id, String bikeName, int bikePrice) {
		return bikeService.saveBike(id, bikeName, bikePrice);
	}

	public String deleteByid(int id) {
		return bikeService.deleteByid(id);
	}

	public List<Bike> getAll() {
		return bikeService.getAll();
	}

	public Bike getById(int id) {
		return bikeService.getByid(id);
	}

	public String updateById(int id, String bikeName, int bikePrice) {
		return bikeService.updateById(id,bikeName,bikePrice);
	}

}