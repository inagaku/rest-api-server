package com.example.restapiserver.request;

import com.example.restapiserver.models.Advertisement;
import com.example.restapiserver.models.AdvertisementWrapper;
import com.example.restapiserver.models.Person;
import com.example.restapiserver.repository.PersonRepository;
import com.example.restapiserver.services.AdvertisementWrapperService;
import com.example.restapiserver.services.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementRestSender implements RestSender {

    @Autowired
    PersonService personService;

    @Autowired
    AdvertisementWrapperService advertisementWrapperService;

    @Override
    public void postRequest(Advertisement advertisement) {
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request.
        HttpEntity<AdvertisementWrapper> requestBody = new HttpEntity<>(advertisementWrapperService.createWrapper(advertisement), headers);

        // Send request with POST method.
//        Object e = restTemplate.postForObject("http://localhost:8082/user/advertisement", requestBody, Person.class);
        System.out.println("http://localhost:8082/user/advertisement");
    }
}
