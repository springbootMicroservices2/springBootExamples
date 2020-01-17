package com.sample.poc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.sample.poc.demo.condition.DevDataSourceCondition;
import com.sample.poc.demo.condition.ProdDataSourceCondition;
import com.sample.poc.demo.util.DataSource;
import com.sample.poc.demo.util.DevDatabaseUtil;
import com.sample.poc.demo.util.ProductionDatabaseUtil;

@Configuration
public class EmployeeDataSourceConfig {

	@Bean(name = "dataSource")
	@Conditional(value = DevDataSourceCondition.class)
	public DataSource getDevDataSource() {
		return new DevDatabaseUtil();
	}

	@Bean(name = "dataSource")
	@Conditional(ProdDataSourceCondition.class)
	public DataSource getProdDataSource() {
		return new ProductionDatabaseUtil();
	}
}