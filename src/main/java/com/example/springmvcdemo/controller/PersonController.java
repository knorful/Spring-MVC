package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.entity.Person;
import com.example.springmvcdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("student1/api/v1/contacts")
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

    @PostMapping
    public String addContact(@ModelAttribute Person person, Model model) {
        return "soon will come";
    }

}
