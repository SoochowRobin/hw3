package com.antra.hw3.controller;

import com.antra.hw3.pojo.Person;
import com.antra.hw3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/person")
    public ResponseEntity<Integer> insert(@RequestBody Person person){
        int id = personService.insert(person);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


}
