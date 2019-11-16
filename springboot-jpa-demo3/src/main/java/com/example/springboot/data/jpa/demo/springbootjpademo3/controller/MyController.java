package com.example.springboot.data.jpa.demo.springbootjpademo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.data.jpa.demo.springbootjpademo3.entity.CityEntity;
import com.example.springboot.data.jpa.demo.springbootjpademo3.servcie.CityService;

@RestController
public class MyController {
	@Autowired
	CityService cityService;

	@GetMapping("/showCitiesEnding")
	public ResponseEntity<List<CityEntity>> findCitiesNameEndsWith(@RequestParam String name) {

		List<CityEntity> cities = cityService.findByNameEndsWith(name);
		return new ResponseEntity<List<CityEntity>>(cities, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/showCities")
	public ResponseEntity<List<CityEntity>> findAllOrderedByNameDescending() {

		List<CityEntity> cities = cityService.findAllOrderedByNameDescending();
		return new ResponseEntity<List<CityEntity>>(cities, new HttpHeaders(), HttpStatus.OK);
	}
}
