package com.example.data_analyzer_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data_analyzer_microservice.model.Data;

public interface DataRepository extends JpaRepository<Data, Long>{
	
}
