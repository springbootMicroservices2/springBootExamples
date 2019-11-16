package com.example.springboot.data.jpa.demo.springbootjpademo2.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.data.jpa.demo.springbootjpademo2.entity.CityEntity;
import com.example.springboot.data.jpa.demo.springbootjpademo2.repository.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repository;

	public List<CityEntity> findByNameEndsWith(String name) {

		List<CityEntity> cities = (List<CityEntity>) repository.findByNameEndsWith(name);
		return cities;
	}
}
