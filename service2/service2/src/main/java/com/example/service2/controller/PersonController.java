package com.example.service2.controller;

import com.example.service2.entity.Person;
import com.example.service2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/setPersonDetails",method= RequestMethod.POST)
    public Person setPersonDetails(@RequestBody Person person) {
        return personService.SavePersonDetails(person);
    }


    @RequestMapping(value = "/personById/{orderId}",method= RequestMethod.GET)
    public Person findByOrderId(@PathVariable int orderId){
        return personService.personById(orderId);
    }



}
