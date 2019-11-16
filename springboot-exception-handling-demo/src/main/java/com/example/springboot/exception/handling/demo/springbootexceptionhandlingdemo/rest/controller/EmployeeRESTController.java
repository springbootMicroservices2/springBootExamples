package com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.exception.RecordNotFoundException;
import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.service.EmployeeService;
import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.vo.EmployeeVO;

@RestController
public class EmployeeRESTController {

	@Autowired
	private EmployeeService service;

	@PostMapping(value = "/employees")
	public ResponseEntity<EmployeeVO> addEmployee(@Valid @RequestBody EmployeeVO employee) {
		service.createOrUpdateEmployee(employee);
		return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") long id) {
		EmployeeVO employee = service.getEmployeeById(id);

		if (employee == null) {
			throw new RecordNotFoundException("Invalid employee id : " + id);
		}
		return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
}
