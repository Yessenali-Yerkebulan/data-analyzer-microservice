package com.example.data_analyzer_microservice.service;

import com.example.data_analyzer_microservice.model.Data;

public class KafkaDataServiceImpl implements KafkaDataService{
    @Override
    public void handle(Data data) {
        System.out.println("Data object is received: " + data.toString());
    }
}
