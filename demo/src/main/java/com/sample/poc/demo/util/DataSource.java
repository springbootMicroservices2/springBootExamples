package com.sample.poc.demo.util;

import java.util.List;

import com.sample.poc.demo.domain.Employee;

public interface DataSource {
	List<Employee> getEmployeeDetails();

}
