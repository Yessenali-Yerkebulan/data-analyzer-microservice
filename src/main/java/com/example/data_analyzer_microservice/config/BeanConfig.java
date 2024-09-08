package com.example.data_analyzer_microservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfig {
    @SneakyThrows
    @Bean
    public XML consumerXML() {
    	return new XMLDocument(
        		getClass().getResourceAsStream("/kafka/consumer.xml")
        			.readAllBytes()
        );
    }
}
