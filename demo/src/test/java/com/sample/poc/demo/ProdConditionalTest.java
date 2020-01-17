package com.sample.poc.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sample.poc.demo.config.EmployeeConfig;
import com.sample.poc.demo.config.EmployeeDataSourceConfig;
import com.sample.poc.demo.domain.Employee;
import com.sample.poc.demo.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { EmployeeConfig.class,
		EmployeeDataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
@TestPropertySource(locations = { "classpath:application-test.properties" })
public class ProdConditionalTest {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testProdDataSource() {
		EmployeeService service = (EmployeeService) applicationContext.getBean("employeeService");
		assertNotNull(service);
		List<Employee> employeeDetails = service.getEmployeeDetails();
		assertEquals(3, employeeDetails.size());
		assertEquals("Ramu", employeeDetails.get(0).getName());
		assertEquals("Charan", employeeDetails.get(1).getName());
		assertEquals("Joe", employeeDetails.get(2).getName());
	}
}
