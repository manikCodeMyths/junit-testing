package com.test.junit.repository;

import com.test.junit.modal.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void givenPersonsAvailable_whenFindAll_thenReturnListOfPerson() {
        Person person1 = new Person();
        person1.setName("Abhinav BABAJI");
        testEntityManager.persist(person1);
        Person person2 = new Person();
        person2.setName("Manik");
        testEntityManager.persist(person2);

        testEntityManager.flush();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);
        Assertions.assertEquals(result.size(),2);

    }

}
