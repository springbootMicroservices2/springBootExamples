package com.sample.poc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.sample.poc.demo.condition.BeanPresennceCondition;
import com.sample.poc.demo.domain.Employee;

@Configuration
public class EmployeeBeanConfig {

	@Bean
	@Conditional(BeanPresennceCondition.class)
	public Employee employee() {
		return new Employee(222, "Popeye", 55000);
	}
}
