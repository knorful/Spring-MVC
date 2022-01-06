package com.example.springmvcdemo.service;

import com.example.springmvcdemo.entity.Person;
import com.example.springmvcdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getContacts() {
        return personRepository.findAll();
    }

    public String addContact(Person person) {
        personRepository.save(person);
        return "Contact Saved";
    }

}
