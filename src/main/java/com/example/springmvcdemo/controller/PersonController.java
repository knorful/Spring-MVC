package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.entity.Person;
import com.example.springmvcdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/")
@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    String getContacts(Model model) {
        var contacts = personService.getContacts();
        model.addAttribute("people", contacts);
        return "people";
    }

    @GetMapping(path = "/edit/{id}")
    public String getEditForm(@PathVariable("id") int personId, Model model) {
        var foundPerson = personService.editContact(personId);
        model.addAttribute("person", foundPerson);
        return "edit-form";
    }

    @PostMapping
    public String addContact(@ModelAttribute("person") Person person, Model model) {
        personService.addContact(person);
        return "redirect:/";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteContact(@ModelAttribute("person") Person person, @PathVariable("id") int personId) {
        personService.deleteContact(personId);
        return "redirect:/";
    }

    @PostMapping(path = "/edit/{id}")
    public String submitEditForm(@PathVariable("id") int personId, Model model, Person person) {
        personService.editContactSubmit(person);
        return "redirect:/";
    }
}
