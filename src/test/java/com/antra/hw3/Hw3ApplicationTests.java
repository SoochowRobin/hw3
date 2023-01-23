package com.antra.hw3;

import com.antra.hw3.pojo.Person;
import com.antra.hw3.repository.PersonRepository;
import com.antra.hw3.service.PersonService;
import com.antra.hw3.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Hw3ApplicationTests {

    SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd");

    private PersonRepository personRepository;
    private Person p1;
    private Person p2;

    @BeforeEach
    public void createPerson() throws ParseException {
        p1 = new Person(null, "robin", "c", "chen", simpleDateFormat.parse("2020-10-01"));
        p2 = new Person(null, "Jerry", "d", "wu", simpleDateFormat.parse("2018-01-01"));
    }

    @Autowired
    public Hw3ApplicationTests(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    public void testInsertion() throws ParseException {
        Person save = personRepository.save(p1);
        Assertions.assertEquals(save, p1);
    }

    @Test
    public void testGetAll(){
        personRepository.save(p1);
        personRepository.save(p2);
        List<Person> all = personRepository.findAll();

        List<Person> correct = new ArrayList<>();
        correct.add(p1);
        correct.add(p2);
        Assertions.assertEquals(correct, all);
    }
}
