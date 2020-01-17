package com.sample.poc.demo.util;

import java.util.List;

import com.sample.poc.demo.domain.Employee;

public class EmployeeDAO {
	private DataSource dataSource;

	public EmployeeDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Employee> getEmployeeDetails() {
		return dataSource.getEmployeeDetails();
	}
}
