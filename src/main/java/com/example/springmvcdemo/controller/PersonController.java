package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.entity.Person;
import com.example.springmvcdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getContacts(Model model) {
        var contacts = personService.getContacts();
        System.out.println("contacts ====> " + contacts);
        model.addAttribute("people", contacts);
        return "people";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("person") Person person, Model model) {
        System.out.println("person ===> " + person.getName());
        personService.addContact(person);
        return "redirect:/";
    }

}
