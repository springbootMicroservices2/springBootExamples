package com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.exception.RecordNotFoundException;
import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.model.EmployeeEntity;
import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.repository.EmployeeRepository;
import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.vo.EmployeeVO;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	public EmployeeVO getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			EmployeeVO vo = new EmployeeVO();
			vo.setEmail(employee.get().getEmail());
			vo.setEmployeeId(employee.get().getId());
			vo.setFirstName(employee.get().getFirstName());
			vo.setLastName(employee.get().getLastName());
			return vo;

		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}

	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeVO vo) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById((long) vo.getEmployeeId());
		EmployeeEntity newEntity = new EmployeeEntity();
		newEntity.setEmail(vo.getEmail());
		newEntity.setFirstName(vo.getFirstName());
		newEntity.setLastName(vo.getLastName());
		if (employee.isPresent()) {
			EmployeeEntity entity = employee.get();
			entity.setEmail(vo.getEmail());
			entity.setFirstName(vo.getFirstName());
			entity.setLastName(vo.getLastName());

			entity = repository.save(newEntity);

			return entity;
		} else {

			newEntity = repository.save(newEntity);

			return newEntity;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}
