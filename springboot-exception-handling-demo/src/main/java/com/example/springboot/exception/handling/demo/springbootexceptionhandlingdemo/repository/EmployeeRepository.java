package com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.exception.handling.demo.springbootexceptionhandlingdemo.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
