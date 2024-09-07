package com.example.data_analyzer_microservice.service.impl;

import com.example.data_analyzer_microservice.model.Data;
import com.example.data_analyzer_microservice.repository.DataRepository;
import com.example.data_analyzer_microservice.service.KafkaDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {
	
	private final DataRepository dataRepository;
	
    @Override
    public void handle(Data data) {
        log.info("Data object {} was saved", data);
        dataRepository.save(data);
    }
}
