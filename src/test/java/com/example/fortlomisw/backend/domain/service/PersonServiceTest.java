package com.example.fortlomisw.backend.domain.service;

import com.example.fortlomisw.backend.domain.model.entity.Multimedia;
import com.example.fortlomisw.backend.domain.persistence.MultimediaRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.persistence.PublicationRepository;
import com.example.fortlomisw.backend.domain.service.PersonService;
import com.example.fortlomisw.backend.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @MockBean
    private UserRepository personrepository;

    @Autowired
    private PersonService personservice;

    @TestConfiguration
    static class PersonServiceTestConfiguration {
        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }



    @Test
    void getByTokenPassword() {
        long id=1;
        byte[] bytes = "hello world".getBytes();
        Person person = new Person();
        person.setId(id);
        person.setUsername("Person 1");
        person.setRealname("Real name 1");
        person.setLastname("Lastname 1");
        person.setEmail("email 1");
        person.setPassword("12345");
        person.setContent(bytes);
        person.setImageprofiletype("Type 1");
        person.setTokenpassword("token 1");

        when(personrepository.findByTokenpassword(person.getTokenpassword())).thenReturn(Optional.of(person));
        Optional<Person> persona = personservice.getByTokenPassword(person.getTokenpassword());
        assertThat(persona.get()).isEqualTo(person);
    }

    @Test
    void getById() {
        long id=1;
        byte[] bytes = "hello world".getBytes();
        Person person =new Person();
        person.setId(id);
        person.setUsername("Person 1");
        person.setRealname("Real name 1");
        person.setLastname("Lastname 1");
        person.setEmail("email 1");
        person.setPassword("12345");
        person.setContent(bytes);
        person.setImageprofiletype("Type 1");
        person.setTokenpassword("token 1");

        when(personrepository.findById(id)).thenReturn(Optional.of(person));
        Person person1 = personservice.getById(id);
        assertThat(person1).isEqualTo(person);
    }

    @Test
    void updateprofile() {
        long id = 1;
        byte[] bytes = "hello world".getBytes();
        Person updatePerson = new Person();
        updatePerson.setId(id);
        updatePerson.setUsername("Person 2");
        updatePerson.setRealname("Real name 2");
        updatePerson.setLastname("Lastname 2");
        updatePerson.setEmail("email 2");
        updatePerson.setPassword("12345");
        updatePerson.setContent(bytes);
        updatePerson.setImageprofiletype("Type 2");
        updatePerson.setTokenpassword("token 2");

        byte[] bytes2 = "hello world 1".getBytes();
        Person oldPerson = new Person();
        oldPerson.setId(id);
        oldPerson.setUsername("Person 1");
        oldPerson.setRealname("Real name 1");
        oldPerson.setLastname("Lastname 1");
        oldPerson.setEmail("email 1");
        oldPerson.setPassword("12345");
        oldPerson.setContent(bytes2);
        oldPerson.setImageprofiletype("Type 1");
        oldPerson.setTokenpassword("token 1");

        when(personrepository.findById(id)).thenReturn(Optional.of(oldPerson));
        when(personrepository.save(updatePerson)).thenReturn(updatePerson);
        when(personrepository.findById(id)).thenReturn(Optional.of(updatePerson));
        Person person = personservice.updateprofile(id,updatePerson);

        assertThat(person).isEqualTo(updatePerson);
    }

    @Test
    void updatepassword() {
        long id = 1;
        byte[] bytes = "hello world".getBytes();
        Person updatePerson = new Person();
        updatePerson.setId(id);
        updatePerson.setUsername("Person 2");
        updatePerson.setRealname("Real name 2");
        updatePerson.setLastname("Lastname 2");
        updatePerson.setEmail("email 2");
        updatePerson.setPassword("123456");
        updatePerson.setContent(bytes);
        updatePerson.setImageprofiletype("Type 2");
        updatePerson.setTokenpassword("token 2");

        byte[] bytes2 = "hello world 1".getBytes();
        Person oldPerson = new Person();
        oldPerson.setId(id);
        oldPerson.setUsername("Person 1");
        oldPerson.setRealname("Real name 1");
        oldPerson.setLastname("Lastname 1");
        oldPerson.setEmail("email 1");
        oldPerson.setPassword("12345");
        oldPerson.setContent(bytes2);
        oldPerson.setImageprofiletype("Type 1");
        oldPerson.setTokenpassword("token 1");

        when(personrepository.findById(id)).thenReturn(Optional.of(oldPerson));
        when(personrepository.save(updatePerson)).thenReturn(updatePerson);
        when(personrepository.findById(id)).thenReturn(Optional.of(updatePerson));

        Person person = personservice.updateprofile(id,updatePerson);

        assertThat(person).isEqualTo(updatePerson);
    }
}