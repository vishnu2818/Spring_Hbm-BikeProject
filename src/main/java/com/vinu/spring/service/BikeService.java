package com.vinu.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinu.spring.Repository.BikeRepository;
import com.vinu.spring.entity.Bike;

@Service
public class BikeService {
	@Autowired
	private BikeRepository bikeRepository;
	@Autowired
	private Bike bike;

	public String saveBike(int id, String bikeName, int bikePrice) {
		Bike check = getByid(id);
		if (check == null) {
			bike.setBikeId(id);
			bike.setBikeName(bikeName);
			bike.setBikePrice(bikePrice);
			return bikeRepository.saveBike(bike);
		} else
			return "duplicate id is not allowed..!";
	}

	public String deleteByid(int id) {
		Bike check = getByid(id);
		if (check != null)
			return bikeRepository.deleteByid(bike);
		else
			return "no record found";
	}

	public List<Bike> getAll() {
		return bikeRepository.getAll();
	}

	public Bike getByid(int id) {
		return bikeRepository.getByid(id);
	}

	public String updateById(int id, String bikeName, int bikePrice) {
		Bike check = getByid(id);
		if (check != null) {
			bike.setBikeName(bikeName);
			bike.setBikePrice(bikePrice);
			return bikeRepository.updateById(bike);
		} else
			return "Oops your specified id: "+id+" is not present..!";
	}

}