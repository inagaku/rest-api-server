package com.example.restapiserver.configuration;

import com.example.restapiserver.models.Person;
import com.example.restapiserver.repository.PersonRepository;
import com.example.restapiserver.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.persistence.AssociationOverride;
import java.util.List;

@Configuration
public class PersonListConfiguration {

    @Autowired
    PersonService personService;

    @Bean("personList")
    public List<Person> personList() {
        return personService.allPersons();
    }
}
