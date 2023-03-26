package com.test.junit.controller;

import com.test.junit.modal.Person;
import com.test.junit.services.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void givenPersonsAvailable_whenGetAllPersons_thenReturnListOfPersons() throws Exception {
        Person person = new Person();
        person.setName("Abhinav");

        List<Person>  personList=Arrays.asList(person);

        Mockito.when(personService.getAllPersons()).thenReturn(personList);

        mockMvc.perform(MockMvcRequestBuilders.get("/persons").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


}
