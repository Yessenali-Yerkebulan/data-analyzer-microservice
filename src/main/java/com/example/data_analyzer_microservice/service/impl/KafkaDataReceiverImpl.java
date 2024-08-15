package com.example.data_analyzer_microservice.service.impl;

import com.example.data_analyzer_microservice.config.LocalDateTimeDeserializer;
import com.example.data_analyzer_microservice.model.Data;
import com.example.data_analyzer_microservice.service.KafkaDataReceiver;
import com.example.data_analyzer_microservice.service.KafkaDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {
        private final KafkaReceiver<String, Object> receiver;
        private final LocalDateTimeDeserializer localDateTimeDeserializer;
        private final KafkaDataService kafkaDataService;

        @PostConstruct
        private void init() {
            fetch();
        }

        @Override
        public void fetch() {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class,
                            localDateTimeDeserializer)
                            .create();

            receiver.receive()
                    .subscribe(r -> {
                        Data data = gson
                                .fromJson(r.value().toString(), Data.class);
                        kafkaDataService.handle(data);
                        r.receiverOffset().acknowledge();
                    });
        }
}
