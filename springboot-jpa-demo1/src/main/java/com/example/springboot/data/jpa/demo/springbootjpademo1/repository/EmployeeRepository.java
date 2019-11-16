package com.example.springboot.data.jpa.demo.springbootjpademo1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.data.jpa.demo.springbootjpademo1.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	void deleteById(Long id);

	List<EmployeeEntity> findAll();

	Optional<EmployeeEntity> findById(Long id);

}
