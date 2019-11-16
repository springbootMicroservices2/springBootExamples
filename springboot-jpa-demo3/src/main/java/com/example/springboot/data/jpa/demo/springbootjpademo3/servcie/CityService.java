package com.example.springboot.data.jpa.demo.springbootjpademo3.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.data.jpa.demo.springbootjpademo3.entity.CityEntity;
import com.example.springboot.data.jpa.demo.springbootjpademo3.repository.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repository;

	public List<CityEntity> findByNameEndsWith(String name) {

		List<CityEntity> cities = (List<CityEntity>) repository.findByNameEndsWith(name);
		return cities;
	}

	public List<CityEntity> findAllOrderedByNameDescending() {

		List<CityEntity> cities = (List<CityEntity>) repository.findAllOrderedByNameDescending();
		return cities;
	}
}
