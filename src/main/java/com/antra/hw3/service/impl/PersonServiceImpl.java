package com.antra.hw3.service.impl;

import com.antra.hw3.pojo.Person;
import com.antra.hw3.repository.PersonRepository;
import com.antra.hw3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public int insert(Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson.getId();
    }
}
