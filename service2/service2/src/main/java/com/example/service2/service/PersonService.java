package com.example.service2.service;

import com.example.service2.entity.Person;
import com.example.service2.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person SavePersonDetails(Person person){
        try {
            return personRepo.save(person);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save person details: " + e.getMessage());
        }
    }

    public Person personById(int orderId){
        Optional<Person> person = personRepo.findByorderId(orderId);
        return person.orElseThrow(() -> {
            throw new RuntimeException("Person with orderId " + orderId + " not found");
        });
    }    }

