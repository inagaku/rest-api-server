package com.example.restapiserver.services;

import com.example.restapiserver.models.Advertisement;
import com.example.restapiserver.models.AdvertisementWrapper;
import com.example.restapiserver.models.Person;
import com.example.restapiserver.request.AdvertisementRestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableKafka
public class KafkaService {

    @Autowired
    AdvertisementRestSender advertisementRestSender;
    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(id = "cian", topics = "cian-flats")
    public void kafkaListener(String inputJson) {
        Advertisement advertisement = objectMapper.readValue(inputJson, Advertisement.class);
        advertisementRestSender.postRequest(advertisement);
    }
}
