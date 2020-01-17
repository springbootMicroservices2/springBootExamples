package com.sample.poc.demo.service;

import java.util.List;

import com.sample.poc.demo.domain.Employee;
import com.sample.poc.demo.util.EmployeeDAO;

public class EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List<Employee> getEmployeeDetails() {
		return employeeDAO.getEmployeeDetails();
	}

}
