package com.antra.hw3.service;

import com.antra.hw3.pojo.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    int insert(Person person);
}
