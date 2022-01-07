package com.example.springmvcdemo.service;

import com.example.springmvcdemo.entity.Person;
import com.example.springmvcdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List getContacts(Integer userId) {
        List<Person> contacts;
        return personRepository.findByUserId(userId).get();
    }

    public String addContact(Person person, int userId) {
        System.out.println("userId = " + userId);
        person.setUserId(userId);
        personRepository.save(person);
        return "Contact Saved";
    }

    public String deleteContact(int personId) {
        personRepository.deleteById(personId);
        return "Contact Deleted!";
    }

    public Person editContact(int personId) {
        var person = personRepository.findById(personId);
        AtomicReference<Person> foundPersonToEdit = new AtomicReference<>();
        person
                .ifPresentOrElse(
                        foundPerson -> {
                            foundPersonToEdit.set(foundPerson);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );

        return foundPersonToEdit.get();

    }

    public String editContactSubmit(Person person, int userId) {
        person.setUserId(userId);
        personRepository.save(person);
        return "Edit Saved!";
    }

    public Person getPerson(int userId) {
        var foundPerson = personRepository.findById(userId);
        AtomicReference<Person> person = new AtomicReference<>();
        foundPerson
                .ifPresentOrElse(
                        p -> {
                            person.set(p);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        });
        return person.get();
    }

}
