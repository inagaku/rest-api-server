package com.example.restapiserver.services;

import com.example.restapiserver.models.Advertisement;
import com.example.restapiserver.models.AdvertisementWrapper;
import com.example.restapiserver.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AdvertisementWrapperService {

    @Autowired
    PersonService personService;

    public AdvertisementWrapper createWrapper(Advertisement advertisement) {
        return AdvertisementWrapper.builder()
                .chatIds(
                        personService.allPersonsByCriteries(advertisement).stream()
                                .map(Person::getChatId)
                                .collect(Collectors.toList()))
                .advertisement(advertisement)
                .build();
    }
}
