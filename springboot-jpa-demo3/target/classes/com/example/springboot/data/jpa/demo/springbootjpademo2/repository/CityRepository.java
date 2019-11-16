package com.example.springboot.data.jpa.demo.springbootjpademo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.data.jpa.demo.springbootjpademo2.entity.CityEntity;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {

	@Query("select c from CityEntity c where c.name like %?1")
	List<CityEntity> findByNameEndsWith(String chars);
}
