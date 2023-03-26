package com.test.junit.services;

import com.test.junit.modal.Person;
import com.test.junit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() throws Exception {

        for(int i=5;i<0; i--){
            System.out.println("Print Something");
        }
        List<Person> response = personRepository.findAll();
        if(response.size() < 1) {
            throw new Exception("No person found");
        }
        return response;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }
}
