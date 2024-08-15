package com.example.data_analyzer_microservice.service;

import com.example.data_analyzer_microservice.model.Data;

public interface KafkaDataService {
    void handle(Data data);
}
