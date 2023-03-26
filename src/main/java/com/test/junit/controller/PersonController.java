package com.test.junit.controller;

import com.test.junit.modal.Person;
import com.test.junit.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() throws Exception {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable int id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }
}
