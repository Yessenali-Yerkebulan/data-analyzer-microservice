package com.example.data_analyzer_microservice.service.impl;

import com.example.data_analyzer_microservice.model.Data;
import com.example.data_analyzer_microservice.service.KafkaDataService;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataServiceImpl implements KafkaDataService {
    @Override
    public void handle(Data data) {
        System.out.println("Data object is received: " + data.toString());
    }
}
