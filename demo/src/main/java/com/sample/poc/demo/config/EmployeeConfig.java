package com.sample.poc.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.poc.demo.service.EmployeeService;
import com.sample.poc.demo.util.DataSource;
import com.sample.poc.demo.util.EmployeeDAO;

@Configuration
public class EmployeeConfig {
	@Autowired
	private DataSource dataSource;

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService(employeeDAO());
	}

	@Bean
	public EmployeeDAO employeeDAO() {
		System.out.println("EmployeeDAO employeeDAO()" + dataSource.toString());
		return new EmployeeDAO(dataSource);
	}

}
