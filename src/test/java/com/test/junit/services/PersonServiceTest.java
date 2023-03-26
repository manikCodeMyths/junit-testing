package com.test.junit.services;

import com.test.junit.modal.Person;
import com.test.junit.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void givenPersonsAvailable_whenGetAllPersons_thenReturnListOfPerson() throws Exception {
        Person person = new Person();
        person.setName("Abhinav");

        List<Person> personList= Arrays.asList(person);
        Mockito.when(personRepository.findAll()).thenReturn(personList);

        List<Person> result = personService.getAllPersons();
        System.out.println(result.get(0).getName()+""+personList.get(0).getName());

        Assertions.assertEquals(result.get(0).getName(),personList.get(0).getName());

        Mockito.verify(personRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void givenPersonsNotAvailable_whenGetAllPersons_thenThrowException() throws Exception {

        Mockito.when(personRepository.findAll()).thenReturn(new ArrayList<>());

        Assertions.assertThrows(Exception.class, ()->{personService.getAllPersons();});

        Mockito.verify(personRepository, Mockito.times(1)).findAll();

    }
}
